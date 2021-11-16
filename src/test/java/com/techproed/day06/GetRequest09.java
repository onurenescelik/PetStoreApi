package com.techproed.day06;

import com.techproed.testBase.DummyTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class GetRequest09 extends DummyTestBase {
    //http://dummy.restapiexample.com/api/v1/employees
    //url ine bir istek gönderildiğinde,
    //status kodun 200,
    //gelen body de,
    //5. çalışanın isminin "Airi Satou" olduğunu ,
    //6. çalışanın maaşının "372000" olduğunu ,
    //Toplam 24 tane çalışan olduğunu,
    //"Rhona Davidson" ın employee lerden biri olduğunu
    //"21", "23", "61" yaşlarında employeeler olduğunu test edin
@Test
 public void test() {
    spec03.pathParam("first","employees");
            Response response = given().
            accept("application/json").
            spec(spec03)
            .when()
            .get("/{first}");
    response.prettyPrint();


    JsonPath jsonPath=response.jsonPath();
    Assert.assertEquals(200,response.getStatusCode());
    //Assert.assertTrue(response.getStatusCode()==200); alternatif

    System.out.println(jsonPath.getList("data.employee_name").size());
    Assert.assertEquals(24,jsonPath.getList("data.employee_name").size());

    Assert.assertEquals("Airi Satou",jsonPath.getString("data[4].employee_name"));
    Assert.assertEquals(372000,jsonPath.getInt("data[5].employee_salary"));

    Assert.assertTrue(jsonPath.getList("data.employee_name").contains("Rhona Davidson"));

    List<Integer> list=new ArrayList<Integer>();
    list.add(21);
    list.add(23);
    list.add(61);

    Assert.assertTrue(jsonPath.getList("data.employee_age").containsAll(list));

 // Assert.assertTrue(jsonPath.getList("data.employee_age").stream().anyMatch(t-> t.equals(21) && t.equals(61) && t.equals(23))); olmadi

}

}
