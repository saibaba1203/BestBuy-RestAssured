package com.studentapp.services;


import com.studentapp.model.ServicesPojo;
import com.studentapp.testbase.TestBaseForServices;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class ServicesPostTest extends TestBaseForServices {

    @Test
    public void createNewServices(){
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Mobile Repair");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(servicesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

}
