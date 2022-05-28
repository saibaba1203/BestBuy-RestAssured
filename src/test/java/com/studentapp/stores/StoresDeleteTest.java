package com.studentapp.stores;


import com.studentapp.testbase.TestBaseForStores;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class StoresDeleteTest extends TestBaseForStores {

    @Test
    public void deleteSingleStoreData(){
        Response response = given()
                .pathParam("id", "8929")
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
