import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.builder.RequestSpecBuilder
import io.restassured.http.ContentType
import org.hamcrest.Matchers.equalTo
import org.junit.Before
import org.junit.Test

class TestVK {
    @Before
    fun init() {
        val token = "2482f57226418bcb4883e15d918f7bfce629fd8ba34fcc0014c2e19f5b6d1b6e262da58fef6225e61a39f"
        RestAssured.requestSpecification = RequestSpecBuilder()
            .setBaseUri("https://api.vk.com/method/")
            .addQueryParam("access_token", token)
            .addQueryParam("v", 5.92)
            .build()
//            .log()
//            .all()
    }

    @Test
    fun test1() {
        given()
            .queryParam("domain", "danil42russia")
        .`when`()
            .post("wall.get")
        .then()
            .assertThat()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("error", equalTo(null))
    }

    @Test
    fun test2() {
        given()
            .queryParam("group_ids", "testpool")
        .`when`()
            .post("groups.getById")
        .then()
            .assertThat()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("error", equalTo(null))
            .body("response.id[0]", equalTo(134304772))
            .body("response.is_closed[0]", equalTo(1))
    }

    @Test
    fun test3() {
        given()
            .queryParam("user_ids", "danil42russia")
            .queryParam("name_case", "gen")
            .queryParam("fields", "city, verified")
        .`when`()
            .post("users.get")
        .then()
            .assertThat()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("error", equalTo(null))
            .body("response.id[0]", equalTo(150705708))
            .body("response.first_name[0]", equalTo("Данила"))
            .body("response.last_name[0]", equalTo("Овчинникова"))
            .body("response.is_closed[0]", equalTo(false))
            .body("response.verified[0]", equalTo(0))
            .body("response.city.title[0]", equalTo("Кемерово"))
    }
}