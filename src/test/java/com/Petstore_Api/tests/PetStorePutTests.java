package com.Petstore_Api.tests;

import com.Petstore_Api.controller.PetStoreApiController;
import com.Petstore_Api.helper.AssertionHelpers;
import com.Petstore_Api.pojos.PetStorePojo;
import com.Petstore_Api.testBase.PetstoreTestBase;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;


public class PetStorePutTests  extends PetstoreTestBase {
    private AssertionHelpers assertionHelpers;

    @Test
    public void PutAnExistingPet(){
        spec.pathParam("param","pet");

        PetStorePojo petStorePojo = PetStorePojo.autoFill();
        petStorePojo.setId(2);
        petStorePojo.setName("shark");

        Gson gson = new Gson();
        String jsonString = gson.toJson(petStorePojo);

        Response response =
                PetStoreApiController.setUpRequest().
                body(jsonString).
                when().
                put("/{param}");


        assertionHelpers.assertSuccessPetResponse(response,petStorePojo.getId(),petStorePojo.getName());

    }

    @Test
    public void ShouldNotPutAnExistingPetWithoutBody(){
        spec.pathParam("param","pet");
try {

    PetStorePojo petStorePojo = PetStorePojo.autoFill();
    petStorePojo.setId(2);
    petStorePojo.setName("shark");

    Response response =
            PetStoreApiController.setUpRequest().
                    when().
                    put("/{param}");

}catch (Exception e) {
    String errorMessage = e.getMessage();
    Assert.assertEquals("status code: 405, reason phrase: Method Not Allowed", errorMessage);
}
    }


}
