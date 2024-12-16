package com.Petstore_Api.helper;

import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;

public class AssertionHelpers {
    public static void assertSuccessPetResponse(Response response, int expectedId, String expectedName) {
        assertEquals("status code should be 200",200, response.getStatusCode());
        assertEquals(expectedId, response.jsonPath().getInt("id"));
        assertEquals(expectedName, response.jsonPath().getString("name"));
    }

}
