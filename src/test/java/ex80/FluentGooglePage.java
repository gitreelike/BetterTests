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
public class FluentGooglePage extends FluentPage {

    public FluentGooglePage search(String term) {
        System.out.println("Search for " + term);
        $(By.name("q"))
                .write(term)
                .submit();

        return this;
    }

    public FluentList<FluentWebElement> result() {
        return $("#search .g .r");
    }

    public void assertHasResult(String resultText) {
        assertThat(result()).hasText(resultText);
    }
}
