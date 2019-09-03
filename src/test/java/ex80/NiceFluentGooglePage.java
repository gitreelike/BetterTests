package ex80;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

@PageUrl("http://www.google.de")
public class NiceFluentGooglePage extends FluentPage {

    @FindBy(name = "q")
    FluentList<FluentWebElement> searchField;

    @FindBy(name = "btnK")
    FluentList<FluentWebElement> findButton;

    @FindBy(css = "#search .g .r")
    FluentList<FluentWebElement> resultElements;

    public NiceFluentGooglePage search(String term) {
        System.out.println("Search for " + term);
        searchField.write(term);
        findButton.submit();

        return this;
    }

    public void assertHasResult(String resultText) {
        assertThat(resultElements).hasText(resultText);
    }
}
