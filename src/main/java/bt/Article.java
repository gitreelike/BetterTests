package bt;

import com.google.common.base.MoreObjects;

public class Article {

    private String name;
    private int price;

    public Article(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("price", price)
                .toString();
    }
}
