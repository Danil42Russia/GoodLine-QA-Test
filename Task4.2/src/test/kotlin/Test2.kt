import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.By

class Test2 : Init("Кемерово проспект Ленина", "Кемерово Бакинский переулок", "среда") {
    @Before
    fun pred() {
        val radioGroup =
            driver.findElement(By.className("RadioGroup"))
        val radioButtons =
            radioGroup.findElements(By.className("RadioButton"))
        radioButtons[radioButtons.size - 1].click()

        driver.findElement(By.className("SearchForm__submit")).click()
        Thread.sleep(5000)
    }

    @Test
    fun test1() {
        val searchSegments =
            driver.findElements(By.className("PopupError"))
        if (searchSegments.size == 0)
            Assert.assertTrue(false)

        val element = searchSegments.find { it.text == "Пункт отправления не найден" }
        Assert.assertTrue(element != null)
    }
}