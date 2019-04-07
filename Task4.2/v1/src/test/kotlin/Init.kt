import org.junit.After
import org.junit.Before
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

open class Init(
    val from: String,
    val to: String,
    val date: String
) {
    lateinit var driver: ChromeDriver

    @Before
    fun init() {
        val path = System.getProperty("user.home")

        System.setProperty(
            "webdriver.chrome.driver",
            "$path//libs//chromedriver.exe"
        )
        driver = ChromeDriver()
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