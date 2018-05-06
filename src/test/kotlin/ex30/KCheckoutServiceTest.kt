package ex30

import bt.*
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.KotlinAssertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class KCheckoutServiceTest {

    @InjectMocks
    lateinit var sut: CheckoutService

    @Mock
    lateinit var discountService: DiscountService

    @Mock
    lateinit var statisticsService: StatisticsService

    @Test
    fun articleDiscountIsSubtractedFromBalance() {
        doReturn(5).whenever(discountService).discount()

        val cart = ShoppingCart(Article("name", 10))

        assertThat(sut.checkout(cart)).isEqualTo(5)
    }

    @Test
    fun checkoutUpdatesStats() {
        val cart = ShoppingCart()

        sut.checkout(cart)

        verify(statisticsService).cartCheckedOut(any())
    }
}

