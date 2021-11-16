package com.techproed.testData;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

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



}
