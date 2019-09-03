package ex80;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@Wait
public class HelloFluentleniumPageTest extends FluentTest {

    @Override
    public WebDriver newWebDriver() {
        WebDriverManager.firefoxdriver().setup();

        FirefoxDriver driver = new FirefoxDriver();

        return driver;
    }

    @Page
    FluentGooglePage google;

    @Test
    public void canSearchUsingPage() {
        google.go();

        google.search("junit");

        google.assertHasResult("JUnit 5");
    }
}
