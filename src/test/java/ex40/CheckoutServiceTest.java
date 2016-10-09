package ex40;

import bt.CheckoutService;
import bt.DiscountService;
import bt.ShoppingCart;
import bt.StatisticsService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import static bt.ShoppingCartTestdataBuilder.anEmptyCart;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class CheckoutServiceTest {

    @Mock
    DiscountService mock;

    @Mock
    StatisticsService statsMock;

    @InjectMocks
    CheckoutService sut;

    /*
        builder kapseln das Erzeugen eines gültigen Testdatums.
        der Builder bietet convenience Methoden an, um Testdaten
        in einem bestimmten Zustand zu erzeugen.
     */

    @Test
    public void checkOutEmptyCartIs0() throws Exception {
        ShoppingCart cart = anEmptyCart().b();

        assertThat(sut.checkout(cart)).isZero();
    }

    /*
        die für den Test relevanten Parameter sind schnell erkennbar
     */

    @Test
    public void cartBalanceIsSumOfArticlePrices() {
        ShoppingCart cart = anEmptyCart()
                .withArticle(10)
                .withArticle(10)
                .b();

        assertThat(sut.checkout(cart)).isEqualTo(20);
    }

    @Test
    public void articleDiscountIsSubtractedFromBalance() {
        doReturn(5).when(mock).discount();

        ShoppingCart cart = anEmptyCart()
                .withArticle(10)
                .b();

        assertThat(sut.checkout(cart)).isEqualTo(5);
    }

}
