package com.techproed.day08;

import com.techproed.testBase.HerokuAppTestBase;
import com.techproed.testData.HerokuappTestData;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetRequest12 extends HerokuAppTestBase {
    /*
    https://restful-booker.herokuapp.com/booking/1 url ine bir istek gönderildiğinde
 dönen response body nin
  {
   "firstname": "Eric",
   "lastname": "Smith",
   "totalprice": 555,
   "depositpaid": false,
   "bookingdates": {
       "checkin": "2016-09-09",
       "checkout": "2017-09-21"
    }
} gibi olduğunu test edin
     */

    @Test
    public void test(){

        spec02.pathParams("first","booking","second",1);

        HerokuappTestData expectedobje=new HerokuappTestData();
         HashMap<String,Object>expectedDataMap= expectedobje.setUpTestData();
         
        Response response = given().
                accept("application/json").
                spec(spec02).
                when().
                get("/{first}/{second}");

        response.prettyPrint();

        HashMap<String, Object> actualData=response.as(HashMap.class);
        System.out.println(actualData);




    }



}
