package Activities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.given;

public class Activity1 {
    String ROOT_URI = "https://petstore.swagger.io/v2/pet";

    @Test(priority = 1)
    public void AddNewPet() {
        // Write the request body
        String reqBody = "{\"id\": 77155,\"name\": \"Riley\",\"status\": \"alive\"}";

        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .body(reqBody).when().post(ROOT_URI); // Send POST request

        // Print response of POST request
        String body = response.getBody().asPrettyString();
        System.out.println(body);

        response.then().body("id", equalTo(77155));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }
    @Test(priority = 2)
    public void simple_get_test() {
        Response response =
                RestAssured.given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("petId", "77155")
                        .get(ROOT_URI + "/{petId}");

        // Print response
        System.out.println(response.asPrettyString());
        // Assertions
        response.then().body("id", equalTo(77155));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));

    }
    @Test(priority = 3)
    public void delete_test(){
        Response response =
                RestAssured.given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("petId", "77155")
                        .delete(ROOT_URI + "/{petId}");
        response.then().body("code", equalTo(200));

        response.then().body("message", equalTo("77155"));
    }


}
