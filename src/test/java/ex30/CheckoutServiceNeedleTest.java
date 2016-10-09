package ex30;

import bt.Article;
import bt.CheckoutService;
import bt.DiscountService;
import bt.ShoppingCart;
import org.junit.Rule;
import org.junit.Test;
import org.needle4j.annotation.ObjectUnderTest;
import org.needle4j.junit.NeedleRule;

import javax.inject.Inject;

import static bt.ShoppingCartTestdataBuilder.anEmptyCart;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

public class CheckoutServiceNeedleTest {

    @Rule
    public NeedleRule needleRule = new NeedleRule();

    /*
        IMHO ist hier ein MockitoTest sprechender bzgl. was passiert

        @Inject = impliziter Mock
        @ObjectUnderTest = wird erzeugt und Mocks werden injiziert
     */

    @Inject
    DiscountService discountService;

    // der zweite Mock wird hier von Needle implizit erzeugt

    @ObjectUnderTest
    CheckoutService sut;

    @Test
    public void checkOutEmptyCartIs0() throws Exception {
        assertThat(sut.checkout(new ShoppingCart())).isZero();
    }

    @Test
    public void cartBalanceIsSumOfArticlePrices() {
        ShoppingCart cart = new ShoppingCart(new Article("name", 10), new Article("name", 20));

        assertThat(sut.checkout(cart)).isEqualTo(30);
    }

    @Test
    public void articleDiscountIsSubtractedFromBalance() {
        doReturn(5).when(discountService).discount();

        ShoppingCart cart = new ShoppingCart(new Article("name", 10));

        assertThat(sut.checkout(cart)).isEqualTo(5);
    }

}
