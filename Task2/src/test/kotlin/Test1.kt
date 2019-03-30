import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver

class Test1 {
    lateinit var productsList: List<WebElement>
    lateinit var driver: ChromeDriver

    @Before
    fun init() {
        val path = System.getProperty("user.home")

        System.setProperty(
            "webdriver.chrome.driver",
            "$path//libs//chromedriver.exe"
        )
        driver = ChromeDriver()

        driver.get("http://цг.рф")
        val elementApp =
            driver.findElement(By.className("presentation__switchers"))
        val elementFood =
            elementApp.findElement(By.ByCssSelector("[data-id='3']"))
        elementFood.click()

        val elementContent =
            driver.findElement(By.className("presentation__content"))
        val elementActive =
            elementContent.findElement(By.className("active"))
        val elementMore =
            elementActive.findElement(By.className("content__more"))
        elementMore.click()
        val scrollId =
            elementMore.getAttribute("data-to")
        val foodSection =
            driver.findElement(By.id(scrollId))

        Thread.sleep(2000)
        val foodElementMore =
            foodSection.findElement(By.className("apps__more"))
        foodElementMore.click()

        Thread.sleep(2000)
        val tabs = driver.windowHandles.toList()//Костыли, как же без них (
        driver.switchTo().window(tabs[1])
        //Тут появляется реклама, но мы нё игнорим :D

        val shopsList =
            driver.findElement(By.className("shops-3bLUah"))

        val shops =
            shopsList.findElements(By.className("shop-card"))
        val elementShop = shops.find { it == shopsList.findElement(By.partialLinkText("Лента")) }
        elementShop?.click()

        val searchFormElement =
            driver.findElement(By.className("search-bar__form"))

        val searchInputElement =
            searchFormElement.findElement(By.className("search-bar__input"))
        searchInputElement.sendKeys("пицца пепперони")
        val searchInputButton =
            searchFormElement.findElement(By.className("search-bar__submit"))
        searchInputButton.click()

        val productsElem =
            driver.findElement(By.className("grid-2KTMB9"))

        Thread.sleep(2000)

        productsList =
            productsElem.findElements(By.className("card-zg1J9N"))
    }

    @Test
    fun testMore1() {
        Assert.assertTrue(productsList.size >= 1)
    }

    @Test
    fun testIsButtonBasket() {
        try {
            productsList.forEach { it.findElement(By.className("button-4nZvAK")) }
            Assert.assertTrue(true)
        } catch (e: Exception) {
            Assert.assertTrue(false)
        }
    }

    @After
    fun close() {
        driver.quit()
    }
}