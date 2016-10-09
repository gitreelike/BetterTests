package ex20;

import bt.Article;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

public class ArticleTest {

    @Test
    public void articleMustBeNamedJunit1() {
        assertNotNull(new Article(null, 10).getName());
    }

    @Test
    public void articleMustBeNamedJunit2() {
        assertNotNull("Article name is null!", new Article(null, 10).getName());
    }

    @Test
    public void articleMustBeNamedAssertJ1() {
        assertThat(new Article(null, 10).getName()).as("Article name is null!").isNotNull();
    }

    @Test
    public void articleMustBeNamedAssertJ2() {
        ArticleAssert.assertThat(new Article(null, 10)).hasName();
    }

    @Test
    public void articlesInListShouldHaveName() throws Exception {
        List<Article> articleList = Arrays.asList(new Article(null, 10), new Article("name", 5));

        assertThat(articleList).areNot(unnamedArticles);
    }

    static Condition<Article> unnamedArticles =
            new Condition<>(article -> article.getName() == null, "an unnamed article");

    static class ArticleAssert extends AbstractAssert<ArticleAssert, Article> {

        private ArticleAssert(Article actual) {
            super(actual, ArticleAssert.class);
        }

        static ArticleAssert assertThat(Article article) {
            return new ArticleAssert(article);
        }

        public ArticleAssert hasName() {
            isNotNull();

            if (actual.getName() == null) {
                failWithMessage("Article is unnamed!");
            }

            return this;
        }
    }
}
