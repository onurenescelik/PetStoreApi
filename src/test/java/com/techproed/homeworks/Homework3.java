package com.techproed.homeworks;

import com.techproed.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


import static io.restassured.RestAssured.given;

public class Homework3 extends JsonPlaceHolderTestBase {
    // /*
    //		1) Create a class and name it as you wish :)
    //		2) When
    //		     I send a GET Request to https://jsonplaceholder.typicode.com/todos
    //		   Then
    //			 HTTP Status code should be "200"
    //			 And Content type should be in "JSON" format
    //			 And there should be 200 "title"
    //			 And "dignissimos quo nobis earum saepe" should be one of the "title"s
    //			 And 111, 121, and 131 should be among the "id"s
    //			 And 4th title is "et porro tempora"
    //			 And last title is "ipsam aperiam voluptates qui"
    //    */


    @Test
    public void test1(){

        spec01.pathParam("first","todos");

        Response response=given().
                accept("application/json").
                spec(spec01).
                when().
                get("/{first}");

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON)
             ;

        JsonPath jsonPath=response.jsonPath();

        Assert.assertTrue(jsonPath.getList("title").size()==200);

        List<Object> json=new ArrayList<>();
        json.add("dignissimos quo nobis earum saepe");
        json.add(111);
        json.add(121);
        json.add(131);

        Assert.assertTrue(jsonPath.getList("title").contains(json.get(0)));
        json.remove(0);
        Assert.assertTrue(jsonPath.getList("id").containsAll(json));

        Assert.assertEquals("et porro tempora",jsonPath.getString("title[3]"));
        Assert.assertEquals("ipsam aperiam voluptates qui",jsonPath.getString("title[-1]"));



    }
}
