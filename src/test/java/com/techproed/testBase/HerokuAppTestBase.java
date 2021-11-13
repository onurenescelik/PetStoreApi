package com.techproed.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuAppTestBase {

    //Create an object in RequestSpecification data type
    protected RequestSpecification spec02;
    //If you use @Before annotation at the top of a method, it means the method will be executed before every test method
   //interview trick'i:  JsonPath is a class, and it has many useful methods "to navigate inside the Json Data"
    @Before
    public void setUp(){
        spec02 = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}
