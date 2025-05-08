package restassured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class bodyDifferences {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    /**
     * Example 1: POST request to create a user
     * Uses JSONObject to build the request body and validates the response.
     */
    @Test
    public void testCreateUserWithJsonObject() throws JSONException {
        // Create JSON request body
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "tamari mumladze");
        requestBody.put("job", "Data Engineer");

        // Send POST request and validate response
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("name", equalTo("tamari mumladze"))
                .body("job", equalTo("Data Engineer"))
                .body("id", not(isEmptyString()))
                .body("createdAt", not(isEmptyString()))
                .extract().response();

        System.out.println("Response: " + response.asString());
    }

    /**
     * Example 2: GET request to retrieve user data with query parameters
     * Demonstrates page parameter usage and response validation.
     */
    @Test
    public void testGetUsersWithQueryParams() {
        // Send GET request with query parameters
        given()
                .contentType(ContentType.JSON)
                .queryParam("page", 2)
                .queryParam("per_page", 3)
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .body("per_page", equalTo(3))
                .body("base/data", hasSize(3))
                .body("data[0]", hasKey("id"))
                .body("data[0]", hasKey("email"))
                .body("data[0]", hasKey("first_name"))
                .body("data[0]", hasKey("last_name"))
                .body("data[0]", hasKey("avatar"))
                .body("total", greaterThan(0))
                .log().body();
    }

    /**
     * Example 3: PUT request to update user data
     * Uses a Map to create the request body and performs detailed response validation.
     */
    @Test
    public void testUpdateUserWithMap() {
        // Using Map for request body
        java.util.Map<String, Object> requestBody = new java.util.HashMap<>();
        requestBody.put("name", "Maria Lopez");
        requestBody.put("job", "Data Scientist");
        requestBody.put("department", "Analytics");
        requestBody.put("skills", java.util.Arrays.asList("SQL", "Python", "Machine Learning"));

        // Send PUT request and validate
        String userId = "2";
        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/users/" + userId)
                .then()
                .statusCode(200)
                .body("name", equalTo("Maria Lopez"))
                .body("job", equalTo("Data Scientist"))
                .body("department", equalTo("Analytics"))
                .body("updatedAt", not(isEmptyString()))
                .extract().response();

        System.out.println("Update Response: " + response.asString());

        // Additional validation on the response time
        long responseTime = response.time();
        System.out.println("Response Time: " + responseTime + " ms");
        assert responseTime < 5000 : "Response time exceeds threshold";
    }
}
