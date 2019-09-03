package ex80;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

@Wait
public class HelloFluentleniumTest extends FluentTest {

    @Override
    public WebDriver newWebDriver() {
        WebDriverManager.firefoxdriver().setup();

        FirefoxDriver driver = new FirefoxDriver();

        return driver;
    }

    @Test
    public void canSearchGoogle() throws Exception {
        goTo("http://www.google.de");

        $(By.name("q")).write("junit");
        $(By.name("btnK")).submit();

        assertThat($("#search .g .r")).hasText("JUnit 5");
    }
}
