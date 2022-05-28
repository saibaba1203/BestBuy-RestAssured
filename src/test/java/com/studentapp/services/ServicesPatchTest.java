package com.studentapp.services;


import com.studentapp.model.ServicesPojo;
import com.studentapp.testbase.TestBaseForServices;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class ServicesPatchTest extends TestBaseForServices {

    @Test
    public void updateServicesWithPatch() {

        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Computers Repairs");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", "26")
                .body(servicesPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
