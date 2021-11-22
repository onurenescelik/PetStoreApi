package com.techproed.day08;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest13 extends DummyTestBase {
//http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
//Status kodun 200 olduğunu,
//5. Çalışan isminin "Airi Satou" olduğunu ,  çalışan sayısının 24 olduğunu,
//Sondan 2. çalışanın maaşının 106450 olduğunu
//40,21 ve 19 yaslarında çalışanlar olup olmadığını
//11. Çalışan bilgilerinin
//  {
// “id”:”11”
// "employee_name": "Jena Gaines",
//"employee_salary": "90560",
//"employee_age": "30",
//"profile_image": "" }
//} gibi olduğunu test edin.

    @Test
    public void test(){

   spec03.pathParam("first","employees");
        DummyTestData expectedobje=new DummyTestData();
        HashMap<String,Object>expectedDataMap=expectedobje.dataSetUp();
        System.out.println(expectedDataMap);

        Response response=given().
                accept("application/json").
                spec(spec03).
                when().
                get("/{first}");

        response.prettyPrint();

        HashMap<String,Object>actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);

        Assert.assertEquals(expectedDataMap.get("statusCode"),response.getStatusCode());

        Assert.assertEquals(expectedDataMap.get("besinciCalisan"),
                ( (Map)  ((List)actualDataMap.get("data")).get(4)).get("employee_name")
        );


        Assert.assertEquals(expectedDataMap.get("calisanSayisi"),((List) actualDataMap.get("data")).size());


        int datasize=((List) actualDataMap.get("data")).size();
        Assert.assertEquals(expectedDataMap.get("sondanIkinciCalisanMaasi"),((Map)((List) actualDataMap.get("data")).get(datasize-2)).get("employee_salary"));


        List<Integer>actualYasListesi=new ArrayList<>();

        for (int i=0;i<datasize;i++){
           actualYasListesi.add ((Integer)((Map)((List) actualDataMap.get("data")).get(i)).get("employee_age"));
        }

        Assert.assertTrue(actualYasListesi.containsAll((List) expectedDataMap.get("arananYaslar")));


        Assert.assertEquals(((Map)expectedDataMap.get("onBirinciCalisan")).get("employee_name"),
                ((Map)((List) actualDataMap.get("data")).get(10)).get("employee_name"));


        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("onBirinciCalisan")).get("employee_salary"),
                ((Map)((List<?>) actualDataMap.get("data")).get(10)).get("employee_salary"));


        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("onBirinciCalisan")).get("employee_age"),
                ((Map) ((List<?>) actualDataMap.get("data")).get(10)).get("employee_age"));


        Assert.assertEquals(((Map<?, ?>) expectedDataMap.get("onBirinciCalisan")).get("profile_image"),
                ((Map) ((List<?>) actualDataMap.get("data")).get(10)).get("profile_image"));














    }





}
