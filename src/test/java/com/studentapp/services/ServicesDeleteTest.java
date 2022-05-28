package com.studentapp.services;


import com.studentapp.testbase.TestBaseForServices;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class ServicesDeleteTest extends TestBaseForServices {

    @Test
    public void deleteSingleService() {
        Response response = given()
                .pathParam("id", "28")
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
