package com.Petstore_Api.tests;


import com.Petstore_Api.controller.PetStoreApiController;
import com.Petstore_Api.helper.AssertionHelpers;
import com.Petstore_Api.pojos.PetStorePojo;
import com.Petstore_Api.testBase.PetstoreTestBase;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class PetStorePostTests extends PetstoreTestBase {
    private AssertionHelpers assertionHelpers;

    @Test
    public void shouldAddNewPetSuccessfully() {
        spec.pathParam("param","pet");
        PetStorePojo petStorePojo = PetStorePojo.autoFill();

        Gson gson = new Gson();
        String jsonString = gson.toJson(petStorePojo);

        Response response =
                PetStoreApiController.setUpRequest().
                body(jsonString).
                when().
                post("/{param}");


        assertionHelpers.assertSuccessPetResponse(response,petStorePojo.getId(),petStorePojo.getName());
        assertEquals("sea creatures",response.jsonPath().getString("category.name"));
        assertEquals(1,response.jsonPath().getInt("category.id"));
        assertEquals(1,response.jsonPath().getInt("tags.id"));
        assertEquals("Gill",response.jsonPath().getInt("tags.name"));


    }

    @Test
    public void ShouldNotAddNewPetToTheStoreWithoutbody(){
        spec.pathParam("param","pet");

        Response response =
                PetStoreApiController.setUpRequest().
                when().
                post("/{param}");

        assertEquals("status code should be 405 if request post without body",405, response.getStatusCode());
        assertEquals("no data",response.jsonPath().getString("message"));
        assertEquals("unknown",response.jsonPath().getString("type"));

    }
    @Test
    public void ShouldNotAddNewPetToTheStoreWithoutContentType(){
        spec.pathParam("param","pet");
        PetStorePojo petStorePojo = PetStorePojo.autoFill();

        Gson gson = new Gson();
        String jsonString = gson.toJson(petStorePojo);

        Response response = given().
                spec(spec).
                header("api_key", "test").
                body(jsonString).
                when().
                post("/{param}");

        assertEquals("status code should be 415 if request post without content-type",415, response.getStatusCode());

    }

    @Test
    public void ShouldNotAddNewPetToTheStoreWithIncorrectURL(){
        spec.pathParam("param","/pet");
        PetStorePojo petStorePojo = PetStorePojo.autoFill();

        Gson gson = new Gson();
        String jsonString = gson.toJson(petStorePojo);

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec).
                header("api_key", "test").
                body(jsonString).
                when().
                post("/{param}");

        assertEquals("status code should be 404 if request post incorrect URL",404, response.getStatusCode());
        response.then()
                .body("apiResponse.message", equalTo("null for uri: http://petstore.swagger.io/v2/%2Fpet"))
                .body("apiResponse.type", equalTo("unknown"));

    }


}
