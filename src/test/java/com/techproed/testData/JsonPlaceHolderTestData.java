package com.techproed.testData;

import java.util.HashMap;

public class JsonPlaceHolderTestData {

    public HashMap<String, Object> setUpTestData() {



        HashMap<String, Object> expectedData = new HashMap<>();

        expectedData.put("statusCode", 200);
        expectedData.put("via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");
        expectedData.put("userId", 1);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);
        return expectedData;
    }
}
