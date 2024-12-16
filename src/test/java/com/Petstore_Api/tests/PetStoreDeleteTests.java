package com.Petstore_Api.tests;

import com.Petstore_Api.controller.PetStoreApiController;
import com.Petstore_Api.testBase.PetstoreTestBase;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PetStoreDeleteTests extends PetstoreTestBase {

    @Test
    public void DeletePet(){
        spec.pathParam("param","pet");

        int id = 2;
        Response response =
                PetStoreApiController.setUpRequest().
                when().
                delete("/{param}/"+id);

        assertEquals("status code should be 200",200, response.getStatusCode());

    }

    @Test
    public void ShouldNotDeletePetWithInvalidID(){
        spec.pathParam("param","pet");
        try {
            int id = 2009453;
            Response response =
                    PetStoreApiController.setUpRequest().
                    when().
                    delete("/{param}/" + id);
        }
        catch (Exception e){
            String errorMessage = e.getMessage();
            Assert.assertEquals("status code: 404, reason phrase: Not Found", errorMessage);
        }

    }

}
