package com.studentapp.stores;


import com.studentapp.model.StoresPojo;
import com.studentapp.testbase.TestBaseForStores;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StoresPostTest extends TestBaseForStores {

    @Test
    public void createNewStore(){

        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("Horley");
        storesPojo.setType("BigBox");
        storesPojo.setAddress("10 Downing Street");
        storesPojo.setAddress2("London Road");
        storesPojo.setCity("London");
        storesPojo.setState("surrey");
        storesPojo.setZip("55305");
        storesPojo.setLat(44.969658);
        storesPojo.setLng(-93.449539);
        storesPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(storesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

}

/*
{
  "name": "string",
  "type": "string",
  "address": "string",
  "address2": "string",
  "city": "string",
  "state": "string",
  "zip": "string",
  "lat": 0,
  "lng": 0,
  "hours": "string",
  "services": {}
}
 */
