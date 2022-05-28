package com.studentapp.services;


import com.studentapp.testbase.TestBaseForServices;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class ServicesGetTest extends TestBaseForServices {

    @Test
    public void getAllServicesList(){
        Response response = given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
