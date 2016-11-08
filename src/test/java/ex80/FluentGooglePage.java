package ex80;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageUrl("http://www.google.de")
@FindBy(name = "q")
public class FluentGooglePage extends FluentPage {

    public void search(String term) {
        System.out.println("Search for " + term);
        $(By.name("q")).write(term + "\n");
    }

    public List<String> results() {
        return $("#search .g .r").textContents();
    }
}
