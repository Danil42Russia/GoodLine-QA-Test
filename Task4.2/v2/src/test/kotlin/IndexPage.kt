import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class IndexPage(private val driver: WebDriver) {

    @FindBy(id = "from")
    lateinit var inputFrom: WebElement

    @FindBy(id = "to")
    private lateinit var inputTo: WebElement

    @FindBy(id = "when")
    private lateinit var inputWhen: WebElement

    @FindBy(className = "SearchForm__submit")
    private lateinit var buttonSubmit: WebElement

    //Не работает :(
    //@FindBy(className = "RadioButton")
    //rivate lateinit var allRadioButton: List<WebElement>

    // Не работает :(
    @FindBy(className = "RadioGroup")
    private lateinit var spanRadioGroup: WebElement

    init {
        PageFactory.initElements(driver, this)
    }

    fun search(from: String, to: String, `when`: String) {
        inputFrom.clear()
        inputFrom.sendKeys(from)
        inputTo.sendKeys(to)
        inputWhen.sendKeys(`when`)
    }

    fun clickButtonSubmit() {
        buttonSubmit.click()
    }

    fun setBus() {
        val allRadioButton =
            spanRadioGroup.findElements(By.className("RadioButton"))

        allRadioButton[allRadioButton.size - 1].click()
    }

    fun close() {
        driver.close()
    }
}
