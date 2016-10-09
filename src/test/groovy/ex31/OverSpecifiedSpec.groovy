package ex31

import bt.CheckoutService
import bt.DiscountService
import bt.ShoppingCart
import bt.StatisticsService
import spock.lang.Specification
import spock.lang.Subject

class OverSpecifiedSpec extends Specification {

    @Subject
    CheckoutService sut = new CheckoutService()

    def setup() {
        sut.discountService = Mock(DiscountService)
        sut.statisticsService = Mock(StatisticsService)
    }

    def cartBalanceIsSumOfArticlePrices() {
        given:
        def cart = new ShoppingCart()

        when:
        def result = sut.checkout(cart)

        then:
        result == 0

        and:
        1 * sut.discountService.discount() >> 0
        1 * sut.statisticsService.cartCheckedOut(cart)
    }

    /**
     * neue Anforderung. wenn der Warenkorb leer ist, soll der statisticService *nicht*
     * mehr aufgerufen werden.
     */
    def noStatsWhenCartWasEmpty() {
        given:
        def cart = new ShoppingCart()

        when:
        sut.checkout(cart)

        then:
        0 * sut.statisticsService.cartCheckedOut(cart)
    }
}
