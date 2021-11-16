package com.techproed.homeworks;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Homework4 extends DummyTestBase {
    @Test
    public void test() {
        // http://dummy.restapiexample.com/api/v1/employee/3 url'ine bir GET request gonderdigimizde
        // donen response'un asagidaki gibi oldugunu test edin.
        //    Response Body
        //    {
        //        "status":"success",
        //        "data":{
        //                "id":3,
        //                "employee_name":"Ashton Cox",
        //                "employee_salary":86000,
        //                "employee_age":66,
        //                "profile_image":""
        //                },
        //        "message":"Successfully! Record has been fetched."
        //    }


        spec03.pathParams("first","employee","second",3);

        Response response=given().
                accept("application/json").
                spec(spec03).
                when().
                get("/{first}/{second}");

        response.prettyPrint();

        DummyTestData dummyTestData=new DummyTestData();
       LinkedHashMap<String, Object> getData=dummyTestData.setUpTestData();



        //1.Yontem
        response.then().assertThat().body("status", equalTo(getData.get("status")),
                "data",equalTo(getData.get("data")),
                "message",equalTo(getData.get("message")));


        //2. yöntem
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(getData.get("status"),jsonPath.getString("status"));
        Assert.assertEquals(getData.get("data"),jsonPath.getMap("data"));
        Assert.assertEquals(getData.get("message"),jsonPath.getString("message"));












    }
}