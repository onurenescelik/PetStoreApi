package com.Petstore_Api.tests;

import com.Petstore_Api.controller.PetStoreApiController;
import com.Petstore_Api.testBase.PetstoreTestBase;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PetStoreGetTests extends PetstoreTestBase {

    @Test
    public void GetPetById(){
        int id = 2;
        Response response =
         PetStoreApiController.setUpRequest().when().get("/{param}/"+id);

        assertEquals("status code should be 200",200, response.getStatusCode());
        assertEquals(2,response.jsonPath().getInt("id"));


    }

    @Test
    public void ShouldNotGetPetByInvalidId(){

        spec.pathParam("param", "pet");
        int id = 20009;

        try {
            Response response =
                    PetStoreApiController.setUpRequest()
                    .when()
                    .get("/{param}/" + id);

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            Assert.assertEquals("status code: 404, reason phrase: Not Found",errorMessage);

        }
    }


}
