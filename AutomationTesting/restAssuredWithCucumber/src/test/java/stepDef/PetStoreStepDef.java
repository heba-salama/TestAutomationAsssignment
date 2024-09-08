package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PetStoreStepDef {

    private Response response;
    private String baseURI = "https://petstore.swagger.io/v2/pet/";


    @When("I request find pet by ID {string}")
    public void findPetById(String petId) {
        response =
                given().log().all().relaxedHTTPSValidation().when().get(baseURI + petId);
        response.then().log().all();
    }

    @Then("Validate the status code is {int}")
    public void validateStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("Validate the returned Pet's name is {string}")
    public void validatePetsName(String expectedPetName) {
        String actualPetName = response.jsonPath().getString("name");
        assertThat(actualPetName, is(expectedPetName));
    }

    @Given("I request find pets by status {string}")
    public void findByStatus(String status) {
        response = given().log().all().relaxedHTTPSValidation().when().get(baseURI + "findByStatus?status=" + status);
        response.then().log().all();
    }

    @Then("Validate all the returned pets with status {string}")
    public void validateReturnedPetsStatus(String status) {
        List<String> statuses = response.jsonPath().getList("status");
        assertThat(statuses, everyItem(equalTo(status)));
    }

    @Given("Add a new Pet with name {string}")
    public void addNewPetToStore(String petName) {
        String jsonPayload = String.format(
                "{ \"id\": 0, \"category\": { \"id\": 0, \"name\": \"string\" }, \"name\": \"%s\", \"photoUrls\": [ \"string\" ], \"tags\": [ { \"id\": 0, \"name\": \"string\" } ], \"status\": \"pending\" }",
                petName
        );
        response = given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .body(jsonPayload)
                .post(baseURI);
        response.then().log().all();
    }


    @Then("Validate the pet {string} created successfully")
    public void validateTheNewPetIsAdded(String addedPetName) {
        String newPetName = response.jsonPath().getString("name");
        assertThat(newPetName, is(addedPetName));
    }
}

