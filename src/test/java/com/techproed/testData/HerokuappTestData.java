package com.techproed.testData;

import java.util.HashMap;

public class HerokuappTestData {

    /*
     {
   "firstname": "Eric",
   "lastname": "Smith",
   "totalprice": 555,
   "depositpaid": false,
   "bookingdates": {
       "checkin": "2016-09-09",
       "checkout": "2017-09-21"
    }
     */
    public HashMap<String, Object> setUpTestData(){
        HashMap<String, Object>bookingdates=new HashMap<>();
        bookingdates.put("checkin","2016-09-09");
        bookingdates.put("checkout","2017-09-21");

        HashMap<String, Object>expectedData=new HashMap<>();
        expectedData.put("firstname","Smith");
        expectedData.put("totalprice",555);
        expectedData.put("depositpaid",false);
        expectedData.put("bookingdates",bookingdates);

        return expectedData;

    }

}
