package com.techproed.day09;

import com.techproed.testBase.DummyTestBase;
import com.techproed.testData.DummyTestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static io.restassured.RestAssured.given;

public class GetRequest14 extends DummyTestBase {



    //http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
    //Status kodun 200 olduğunu,
    //En yüksek maaşın 725000 olduğunu,
    //En küçük yaşın 19 olduğunu,
    //İkinci en yüksek maaşın 675000
    //olduğunu test edin.

    @Test
    public void test() {
        spec03.pathParam("parametre1", "employees");

        DummyTestData expectedObje = new DummyTestData();
        HashMap<String, Integer>expectedDataMap= expectedObje.setUpTestData02();
        System.out.println(expectedDataMap);

        Response response=given().
                accept("application/json").
                spec(spec03).
                when().
                get("/{parametre1}");

        response.prettyPrint();


        HashMap<String,Object> actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);

        Assert.assertEquals(expectedDataMap.get("statusCode"),(Integer) response.getStatusCode());

        List<Integer>maasListesi=new ArrayList<>();

        for (int i = 0; i <((List)actualDataMap.get("data")).size(); i++) {

            maasListesi.add((Integer) ((Map) ((List) actualDataMap.get("data")).get(i)).get("employee_salary"));

        }

        Collections.sort(maasListesi);
       Assert.assertEquals( expectedDataMap.get("enYuksekMaas"),maasListesi.get(maasListesi.size()-1));

       Assert.assertEquals(expectedDataMap.get("ikinciYuksekMaas"),maasListesi.get(maasListesi.size()-2));

        List<Integer> yasListesi = new ArrayList<>();
        for (int i = 0; i <((List)actualDataMap.get("data")).size(); i++) {
        yasListesi.add((Integer) ((Map)((List)actualDataMap.get("data")).get(i)).get("employee_age"));

        }
        Collections.sort(yasListesi);
        Assert.assertEquals( expectedDataMap.get("enKucukYas"),yasListesi.get(0));



        //2-JsonPath ile

        JsonPath jsonPath=response.jsonPath();
       List<Integer>maasListesiJson= jsonPath.getList("data.employee_salary");
       Collections.sort(maasListesiJson);
       Assert.assertEquals(expectedDataMap.get("enYuksekMaas"),maasListesiJson.get(maasListesi.size()-1));
        Assert.assertEquals(expectedDataMap.get("ikinciYuksekMaas"),maasListesiJson.get(maasListesi.size()-2));

        List<Integer> yasListesijson=jsonPath.getList("data.employee_age");
        Collections.sort(yasListesijson);
        Assert.assertEquals(expectedDataMap.get("enKucukYas"),yasListesijson.get(0));







    }



}
