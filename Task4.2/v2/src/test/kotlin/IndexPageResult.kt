import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class IndexPageResult(private val driver: WebDriver) {

    //Не работает :(
    //@FindBy(className = "SearchSegment")
    //lateinit var allSearchSegment: List<WebElement>

    @FindBy(className = "SearchSegments")
    lateinit var sectionSearchSegment: WebElement
    fun allSearchSegment(): List<WebElement> {
        return sectionSearchSegment.findElements(By.className("SearchSegment"))
    }

    //Не работает :(
    //@FindBy(className = "PopupError")
    //lateinit var allPopupErrors: List<WebElement>
    fun allPopupErrors(): List<WebElement> {
        return driver.findElements(By.className("PopupError"))
    }

    init {
        PageFactory.initElements(driver, this)
    }
}
