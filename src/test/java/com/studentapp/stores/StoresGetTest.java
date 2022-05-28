package com.studentapp.stores;


import com.studentapp.testbase.TestBaseForStores;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StoresGetTest extends TestBaseForStores {

    @Test
    public void getAllStoresList(){
        Response response = given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
