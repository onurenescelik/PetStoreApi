package com.techproed.day14;

import com.techproed.testBase.HerokuAppTestBase;
import com.techproed.utilities.JsonUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequestWithObjectMapper02 extends HerokuAppTestBase {

    /*
 https://restful-booker.herokuapp.com/booking/2 url’ine bir get request gönderildiğinde,
status kodun 200 ve response body’nin
{
 "firstname": "Mark",
 "lastname": "Wilson",
 "totalprice": 284,
 "depositpaid": false,
 "bookingdates": {
"checkin": "2016-08-10",
"checkout": "2018-06-22"
 }
 }
Olduğunu Object Mapper kullanarak test edin
     */

@Test
    public void test(){

    spec02.pathParams("first","booking","second",2);

    String jsonData="{\n" +
            " \"firstname\": \"Susan\",\n" +
            " \"lastname\": \"Brown\",\n" +
            " \"totalprice\": 128,\n" +
            " \"depositpaid\": true,\n" +
            " \"bookingdates\": {\n" +
            "\"checkin\": \"2020-07-17\",\n" +
            "\"checkout\": \"2021-07-19\"\n" +
            " }\n" +
            " }";

     HashMap<String,Object>expectedData=JsonUtil.convertJsonToJava(jsonData, HashMap.class);
    System.out.println(expectedData);

    Response response=given().
            contentType(ContentType.JSON).
            spec(spec02).
            when().
            get("/{first}/{second}");

    response.prettyPrint();

     HashMap<String, Object>actualData=JsonUtil.convertJsonToJava(response.asString(),HashMap.class);

    System.out.println(actualData);

    Assert.assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
    Assert.assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
    Assert.assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
    Assert.assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
    Assert.assertEquals(expectedData.get("bookingdates"),actualData.get("bookingdates"));
    Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"),
            ((Map) actualData.get("bookingdates")).get("checkin"));
    Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"),
            ((Map) actualData.get("bookingdates")).get("checkout"));
//    Assert.assertEquals(expectedData.get("bookingdates.checkin"),actualData.get("bookingdates.checkin"));
//    Assert.assertEquals(expectedData.get("bookingdates.checkout"),actualData.get("bookingdates.checkout")); -> boylede calisti


}




















}
