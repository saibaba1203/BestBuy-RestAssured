package com.studentapp.stores;

import com.studentapp.model.StoresPojo;
import com.studentapp.testbase.TestBaseForStores;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StoresPutTest extends TestBaseForStores {

    @Test
    public void updateStoreDataWithPut(){
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("Crawley");
        storesPojo.setType("BigBox");
        storesPojo.setAddress("10 Downland Drive");
        storesPojo.setAddress2("London Road");
        storesPojo.setCity("Crawley");
        storesPojo.setState("Sussex");
        storesPojo.setZip("55077");
        storesPojo.setLat(44.969658);
        storesPojo.setLng(-93.449539);
        storesPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id","8928")
                .body(storesPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
