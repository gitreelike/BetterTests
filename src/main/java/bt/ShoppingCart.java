package bt;

import java.util.Arrays;
import java.util.List;

public class ShoppingCart {

    public ShoppingCart(List<Article> articles) {
        this.articles = articles;
    }

    public ShoppingCart(Article... articles) {
        this(Arrays.asList(articles));
    }

    final List<Article> articles;
}
