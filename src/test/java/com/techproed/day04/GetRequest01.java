package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class GetRequest01 {

    //https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde donecek cevap(response) icin
    //HTTP status kodunun 200
    //Content Type'in Json
    //Ve Status Line'in HTTP/1.1 200 OK
    //Oldugunu test edin
@Test
public void test01() {

//    1-Api testi yaparken ilk olarak url(endpoint) belirlenmeli
    String url = "https://restful-booker.herokuapp.com/booking/3";
//
//    2-Beklenen sonuc (expected result) olusturulur.
//bu case de benden body dogrulanmasi istenmedigi icin simdilik beklenen sonuc olusturmuyoruz
//
//    3-request gonder
   Response response= given().
           accept("application/json").
           when().
           get(url);
    response.prettyPrint();
//    4-actual result olustur
    //response body ile ilgili islem yapmayacagimiz icin simdi olusturmayacagiz
//    5-dogrulama yap (Assertion)
    System.out.println("Status Code: "+response.getStatusCode());//response'dan gelen status code'u verir
    System.out.println("Content Type: "+response.getContentType());//response'dan gelen content type'i verir
    System.out.println("Status Line: "+response.getStatusLine());//response'dan gelen status Line'i verir
    System.out.println("response.getHeaders() = " + response.getHeaders());

    /*
    Assert.assertEquals(200,response.getStatusCode());
    //expected kismi bize task olarak verilen degerdir, actual kismi ise response'dan donen degerdir.
    //status code int deger dondurur
    Assert.assertEquals("application/json; charset=utf-8",response.getContentType());
    Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
     */
    response.
            then().
            assertThat().
            statusCode(200).
            contentType(ContentType.JSON).  //accept("application/json") yerine geciyor
            statusLine("HTTP/1.1 200 OK");

}
}
