package restassured;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class getMoney {

//    @Test
//    public void getMoney() {
//        Response response =
//                given().header("authorization", "Bearer 188219|NVyPLREn0nO2NxYr3LLifenZlTCwIV1RDl3CDeTh").
//                        header("content-type", "application/json").
//                        when()
//                        .get("https://new.expressgroup.ge/api/Dashboard/products")
//                        .then()
//                        .extract().response();
//
//        System.out.println(response.asString());
//        System.out.println(response.body().jsonPath().get("[0].title").toString());
//        System.out.println(response.statusCode());
//    }

    @Test
    public void testGetRequest() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200);
    }
    @Test
    public void testWithHeadersAndAuth() {
        given()
                .baseUri("https://api.example.com")
                .header("Content-Type", "application/json")
                .auth().basic("username", "password")
                .when()
                .get("/secure-endpoint")
                .then()
                .statusCode(200);
    }
    @Test
    public void extractResponseData() {
        String title = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .extract().path("title");
        Assert.assertNotNull(title);
        System.out.println("Post title: " + title);
    }

}

