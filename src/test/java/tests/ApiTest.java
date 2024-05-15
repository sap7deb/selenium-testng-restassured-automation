package tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTest {

    @BeforeTest
    public void setUp() {
        // RequestSpecification specification = given();
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "api/users";

    }

    @Test
    public void testApi() {
        System.out.println(given().header("s", "").when().get("/2").then().extract().path("data.email").toString());
        given().when().get("/2").then().statusCode(200);

    }
}
