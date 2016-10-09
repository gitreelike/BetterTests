package ex30

import bt.Article
import bt.CheckoutService
import bt.ShoppingCart
import com.nhaarman.mockito_kotlin.*
import org.assertj.core.api.KotlinAssertions.assertThat
import org.junit.Before
import org.junit.Test


class KMockitoCheckoutServiceTest {

    val sut = CheckoutService()

    /*
        Mockito-kotlin:
        reified type parameter erlaubt es, den Typparameter hier wegzulassen (Kotlin Feature)
      */

    @Before
    fun setup() {
        sut.discountService = mock()
        sut.statisticsService = mock()
    }

    @Test
    fun articleDiscountIsSubtractedFromBalance() {
        doReturn(5).whenever(sut.discountService).discount()

        val cart = ShoppingCart(Article("name", 10))

        assertThat(sut.checkout(cart)).isEqualTo(5)
    }

    @Test
    fun checkoutUpdatesStats() {
        val cart = ShoppingCart()

        sut.checkout(cart)

        verify(sut.statisticsService).cartCheckedOut(any())
    }
}

