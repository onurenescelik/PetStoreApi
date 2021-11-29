package com.techproed.testData;

import org.json.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class DummyTestData {






        public LinkedHashMap<String, Object> setUpTestData () {
            LinkedHashMap<String, Object> getInnerData = new LinkedHashMap<>();
            getInnerData.put("id", 3);
            getInnerData.put("employee_name", "Ashton Cox");
            getInnerData.put("employee_salary", 86000);
            getInnerData.put("employee_age", 66);
            getInnerData.put("profile_image", "");

            LinkedHashMap<String, Object> getOutData = new LinkedHashMap<>();


         getOutData.put("status", "success");
            getOutData.put("data", getInnerData);
            getOutData.put("message", "Successfully! Record has been fetched.");
            System.out.println(getOutData);
        System.out.println(getInnerData);

           return getOutData;

    }

    public HashMap<String,Object> dataSetUp(){

        List<Integer>yaslar=new ArrayList<>();
        yaslar.add(40);
        yaslar.add(21);
        yaslar.add(19);

        HashMap<String,Object>onBirinci=new HashMap<>();
        onBirinci.put("id",11);
        onBirinci.put("employee_name","Jena Gaines");
        onBirinci.put("employee_salary",90560);
        onBirinci.put("employee_age",30);
        onBirinci.put("profile_image","");


        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("statusCode",200);
        expectedData.put("besinciCalisan","Airi Satou");
        expectedData.put("calisanSayisi",24);
        expectedData.put("sondanIkinciCalisanMaasi",106450);
        expectedData.put("arananYaslar",yaslar);
        expectedData.put("onBirinciCalisan",onBirinci);



          return expectedData;



    }

    public HashMap<String, Integer> setUpTestData02(){

        HashMap<String,Integer> expectedData=new HashMap<String, Integer>();
        expectedData.put("statusCode",200);
        expectedData.put("enYuksekMaas",725000);
        expectedData.put("enKucukYas",19);
        expectedData.put("ikinciYuksekMaas",675000);
        return expectedData;


    }

    public HashMap<String,String> setUpRequestBody(){

           HashMap<String,String>requestBody=new HashMap<String,String>();
           requestBody.put("name","Myra");
           requestBody.put("salary","150000");
           requestBody.put("age","24");

            return requestBody;


    }

    public HashMap<String,Object> setUpExpectedData(){

        HashMap<String,Object>data=new HashMap<>();
        data.put("name","Myra");
        data.put("salary","150000");
        data.put("age","24");

        HashMap<String,Object>expectedData=new HashMap<>();
        expectedData.put("statusCode",200);
        expectedData.put("status","success");
        expectedData.put("data",data);
        expectedData.put("message","Successfully! Record has been added.");

        return expectedData;




    }

    public JSONObject setUpDeleteExpectedData(){
        JSONObject delete=new JSONObject();
        delete.put("status","success");
        delete.put("data","2");
        delete.put("message","Successfully! Record has been deleted");
        return delete;
    }




}
