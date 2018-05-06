import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.chrome.ChromeDriver

driver = {
    ChromeDriverManager.getInstance().setup()

    def driver = new ChromeDriver()

    driver
}