import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.chrome.ChromeDriver

import java.util.concurrent.TimeUnit

driver = {
    ChromeDriverManager.getInstance().setup()

    def driver = new ChromeDriver()

    driver
}