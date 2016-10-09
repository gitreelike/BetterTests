package bt;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTestdataBuilder {

    List<Article> articles = new ArrayList<>();

    public static ShoppingCartTestdataBuilder anEmptyCart() {
        return new ShoppingCartTestdataBuilder();
    }

    public ShoppingCartTestdataBuilder withArticle(int price) {
        articles.add(new Article("anyValidName", price));
        return this;
    }

    public ShoppingCart b() {
        return new ShoppingCart(articles);
    }
}
