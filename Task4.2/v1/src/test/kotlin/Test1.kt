import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.By

class Test1 : Init("Кемерово", "Москва", "7 июля") {
    @Before
    fun pre() {
        driver.findElement(By.className("SearchForm__submit")).click()
        Thread.sleep(5000)
    }

    @Test
    fun test1() {
        val searchSegments =
            driver.findElements(By.className("SearchSegment"))
        if (searchSegments.size == 0)
            Assert.assertTrue(false)
        try {
            searchSegments.forEach { it.findElement(By.className("SegmentTitle__title")) }
            Assert.assertTrue(true)
        } catch (e: Exception) {
            Assert.assertTrue(false)
        }
    }

    @Test
    fun test2() {
        val searchSegments =
            driver.findElements(By.className("SearchSegment"))
        if (searchSegments.size == 0)
            Assert.assertTrue(false)
        try {
            searchSegments.forEach { it.findElement(By.className("SearchSegment__duration")) }
            Assert.assertTrue(true)
        } catch (e: Exception) {
            Assert.assertTrue(false)
        }
    }

    @Test
    fun test3() {
        val searchSegments =
            driver.findElements(By.className("SearchSegment"))
        if (searchSegments.size == 0)
            Assert.assertTrue(false)
        try {
            searchSegments.forEach { it.findElement(By.className("TransportIcon__icon")) }
            Assert.assertTrue(true)
        } catch (e: Exception) {
            Assert.assertTrue(false)
        }
    }

    @Test
    fun test4() {
        val searchSegments =
            driver.findElements(By.className("SearchSegment"))
        Assert.assertTrue(searchSegments.size == 5)
    }
}