package ex80;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.hook.wait.Wait;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

@Wait
public class HelloFluentleniumTest extends FluentTest {

    @Override
    public WebDriver newWebDriver() {
        ChromeDriverManager.getInstance().setup();

        ChromeDriver driver = new ChromeDriver();

        return driver;
    }

    @Test
    public void canSearchGoogle() throws Exception {
        goTo("http://www.google.de");

        $(By.name("q")).write("junit\n");

        assertThat($("#search .g .r")).hasText("JUnit - About");
    }

    @Page
    FluentGooglePage page;

    @Test
    public void canSearchUsingPage() throws Exception {
        page.go();

        page.search("junit");

        assertThat(page.results()).contains("JUnit - About");
    }
}
