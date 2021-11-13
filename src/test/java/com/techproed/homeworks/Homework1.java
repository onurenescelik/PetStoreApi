package com.techproed.homeworks;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Homework1 {
    // https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request gonderdigimizde donen Response'un,
    //        status code'unun 200,
    //        ve content type'inin application/json; charset=utf-8,
    //        ve Server isimli Header'in degerinin Cowboy,
    //        ve status Line'in HTTP/1.1 200 OK
    //        ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.

    @Test
    public void test() {

        String url="https://restful-booker.herokuapp.com/booking/10";

        Response response= given().
                accept("application/json").
                when().
                get(url);
        response.prettyPrint();

        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                header("Server", equalTo("Cowboy")).
                statusLine("HTTP/1.1 200 OK").
                time(lessThan((long)5000));

    }
}
