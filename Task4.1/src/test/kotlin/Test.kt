import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.builder.RequestSpecBuilder
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Before
import org.junit.Test

class Test {
    @Before
    fun init() {
        val token = "ae02e7b6-7fe6-4201-ab48-d47447da3d13"
        RestAssured.requestSpecification = RequestSpecBuilder()
            .setBaseUri("https://api.rasp.yandex.net/v3.0")
            .addQueryParam("apikey", token)
            .addQueryParam("lang", "ru_RU")
            .addQueryParam("format", "json")
            .build()
//            .log()
//            .all()
    }

    @Test
    fun nearest_settlement() {
            given()
                .param("lat", 55.276508)
                .param("lng", 85.615223)
                .param("distance", 50)
            .`when`()
                .get("/nearest_settlement")
            .then()
                .assertThat()
                .statusCode(200)
                .body("code", equalTo("c11297"))
                .body("title", equalTo("Топки"))
    }

    @Test
    fun search() {
            given()
                .param("from", "c64")
                .param("to", "c213")
                .param("date", "2019-07-08")
            .`when`()
                .get("/search")
            .then()
                .assertThat()
                .statusCode(200)
                .body("pagination.total", equalTo(4))
                .body("search.to.title", equalTo("Москва"))
                .body("search.from.title", equalTo("Кемерово"))
    }

    @Test
    fun thread() {
            given()
                .param("uid", "SU-1451_5_c26_547")
            .`when`()
                .get("/thread")
            .then()
                .assertThat()
                .statusCode(200)
                .body("title", equalTo("Кемерово — Москва"))
                .body("start_time", equalTo("06:50"))
                .body("stops.size()", equalTo(2))
                .body("vehicle", equalTo("Airbus A321"))
    }
}