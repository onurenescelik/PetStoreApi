package com.Petstore_Api.controller;

import com.Petstore_Api.testBase.PetstoreTestBase;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class PetStoreApiController extends PetstoreTestBase {

    public static RequestSpecification setUpRequest() {
        spec.pathParam("param", "pet");
        return given()
                .contentType("application/json")
                .spec(spec)
                .header("api_key", "test");
    }
}
