package ex40

import bt.CheckoutService
import bt.DiscountService
import bt.ShoppingCart
import bt.StatisticsService
import spock.lang.Specification
import spock.lang.Subject

import static bt.ShoppingCartTestdataBuilder.anEmptyCart

class CheckoutServiceSpec extends Specification {

    @Subject
    CheckoutService sut = new CheckoutService()

    def setup() {
        sut.discountService = Mock(DiscountService)
        sut.statisticsService = Mock(StatisticsService)
    }

    def emptyCartHasABalanceOf0() {
        given:
        def cart = anEmptyCart().b()

        expect:
        sut.checkout(cart) == 0
    }

    def cartBalanceIsSumOfArticlePrices() {
        given:
        def cart = anEmptyCart()
                .withArticle(10)
                .withArticle(10)
                .b();

        expect:
        sut.checkout(cart) == 20
    }

    def articleDiscountIsSubtractedFromBalance() {
        given:
        sut.discountService.discount() >> 5

        and:
        def cart = anEmptyCart()
                .withArticle(10)
                .b();

        expect:
        sut.checkout(cart) == 5
    }

    def checkoutUpdatesStats() {
        given:
        def cart = anEmptyCart().b()

        when:
        sut.checkout(cart)

        then:
        1 * sut.statisticsService.cartCheckedOut(_)
    }

}
