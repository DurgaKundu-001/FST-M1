package Activities;

import java.io.File;

import java.io.FileInputStream;

import java.io.FileWriter;

import java.io.IOException;


import io.restassured.RestAssured;
import org.testng.annotations.Test;



import io.restassured.http.ContentType;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.equalTo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity2 {
    String ROOT_URI = "https://petstore.swagger.io/v2/user";

    @Test(priority = 1)
    public void AddNewPet() throws IOException {
                   // Import JSON file
            File file = new File("src/test/Resource/Act2Data.json");
            FileInputStream inputJSON = new FileInputStream(file);
            // Get all bytes from JSON file
            byte[] bytes = new byte[(int) file.length()];
            inputJSON.read(bytes);
            // Read JSON file as String
            String reqBody = new String(bytes, "UTF-8");

            System.out.println(reqBody);

            Response response = given()
                    .contentType(ContentType.JSON) // Set headers
                    .body(reqBody) // Pass request body from file
                    .when().post(ROOT_URI); // Send POST request

            // Print response
            String body = response.getBody().asPrettyString();
            System.out.println(body);

            inputJSON.close();

            // Assertion
            response.then().body("message", equalTo("12304"));
            response.then().body("code", equalTo(200));
        }
    @Test(priority = 2)
    public void simple_get_test() {
        File outputJSON = new File("src/test/java/Activities/Act2GETResponse.json");
        Response response =
                RestAssured.given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("username", "kdurga")
                        .get(ROOT_URI + "/{username}");

        String resBody = response.getBody().asPrettyString();
        try {
             outputJSON.createNewFile();
             FileWriter writer = new FileWriter(outputJSON.getPath());
             writer.write(resBody);
             writer.close();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
        response.then().body("id", equalTo(12304));
        response.then().body("username", equalTo("kdurga"));
        response.then().body("firstName", equalTo("durga"));
        response.then().body("lastName", equalTo("Case"));
        response.then().body("email", equalTo("justincase@mail.com"));
        response.then().body("phone", equalTo("9812763450"));

            }
    @Test(priority = 3)
    public void delete_test(){
        Response response =
                RestAssured.given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("username", "kdurga")
                        .delete(ROOT_URI + "/{username}");
        response.then().body("code", equalTo(200));

        response.then().body("message", equalTo("kdurga"));
    }

}

