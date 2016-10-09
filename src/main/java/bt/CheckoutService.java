package bt;

public class CheckoutService {

    public DiscountService discountService;

    public StatisticsService statisticsService;

    public int checkout(ShoppingCart shoppingCart) {
        int balance = 0;

        for (Article article : shoppingCart.articles) {
            balance += article.getPrice();
        }
        balance -= discountService.discount();

        statisticsService.cartCheckedOut(shoppingCart);

        return balance;
    }
}
