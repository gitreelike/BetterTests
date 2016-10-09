package ex30;

import bt.Article;
import bt.CheckoutService;
import bt.DiscountService;
import bt.ShoppingCart;
import bt.StatisticsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutServiceMockitoTest {

    @Mock
    DiscountService discountService;

    @Mock
    StatisticsService statisticsService;

    @InjectMocks
    CheckoutService sut;

    /*
        die Kollaborateure wurden durch Mocks ersetzt
        Sie verhalten sich neutral und bleiben damit zunächst im Hintergrund
     */

    @Test
    public void checkOutEmptyCartIs0() throws Exception {
        assertThat(sut.checkout(new ShoppingCart())).isZero();
    }

    @Test
    public void cartBalanceIsSumOfArticlePrices() {
        ShoppingCart cart = new ShoppingCart(new Article("name", 10), new Article("name", 20));

        assertThat(sut.checkout(cart)).isEqualTo(30);
    }

    /*
        durch Stubbing kann dem SUT ein indirekter In Parameter übergeben werden
     */

    @Test
    public void articleDiscountIsSubtractedFromBalance() {
        doReturn(5).when(discountService).discount();

        ShoppingCart cart = new ShoppingCart(new Article("name", 10));

        assertThat(sut.checkout(cart)).isEqualTo(5);
    }

    /*
        durch eine verification auf einem Stub prüfen wir eine
        indirekte Ausgabe
     */

    @Test
    public void checkoutUpdatesStats() throws Exception {
        ShoppingCart cart = new ShoppingCart();

        sut.checkout(cart);

        verify(statisticsService).cartCheckedOut(Mockito.any());
    }

}
