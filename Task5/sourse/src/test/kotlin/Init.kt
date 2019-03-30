import org.junit.After
import org.junit.Before
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URI

open class Init(
    val from: String,
    val to: String,
    val date: String
) {
    lateinit var driver: RemoteWebDriver

    @Before
    fun init() {
        val browser = System.getenv("test.browser")
        val version = System.getenv("test.version")

        val capabilities = DesiredCapabilities()
        capabilities.browserName = browser
        capabilities.version = version
        capabilities.setCapability("enableVNC", true)
        capabilities.setCapability("enableVideo", false)

        driver = RemoteWebDriver(
            URI.create("http://localhost:4444/wd/hub").toURL(),
            capabilities
        )

        driver.get("https://rasp.yandex.ru/")

        val searchForm =
            driver.findElement(By.className("SearchForm"))
        val fromCityElem =
            searchForm.findElement(By.id("from"))
        val toCityElem =
            searchForm.findElement(By.id("to"))
        val dateElem =
            searchForm.findElement(By.id("when"))

        fromCityElem.clear()
        fromCityElem.sendKeys(from)
        toCityElem.sendKeys(to)
        dateElem.sendKeys(date)
    }

    @After
    fun close() {
        driver.quit()
    }
}