package com.studentapp.services;


import com.studentapp.model.ServicesPojo;
import com.studentapp.testbase.TestBaseForServices;
import gherkin.deps.com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class ServicesCRUDTest extends TestBaseForServices {

    static String name = "Apple Shop";
    static Integer servicesId;

    // Create new service with - POST
    @Test
    public void test001() {
        ServicesPojo servicesPojo = new ServicesPojo(); // create object of ServicePojo class
        servicesPojo.setName(name);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(servicesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    // Extract servicesId of newly created product
    @Test
    public void test002() {
        String p1 = "data.findAll{it.name='";
        String p2 = "'}.get(0)";

        HashMap value =
                given()
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path(p1 + name + p2);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(value));
        servicesId = (Integer) value.get("id");
    }

    // Update product record with PUT
    @Test
    public void test003() {
        String p1 = "data.findAll{it.name='";
        String p2 = "'}.get(0)";


        name = name + " (Updated)";

        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName(name);

        given()
                .header("Content-Type", "application/json")
                .pathParam("serviceId", servicesId)
                .body(servicesPojo)
                .when()
                .put("/{serviceId}")
                .then().log().all().statusCode(200);

        // Assert response with 'id' after extracting by 'name'
        HashMap<String, Object> value =

                given()
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path(p1 + name + p2);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(value));
    }

    // Delete record with - DELETE
    @Test
    public void test004(){

        given()
                .pathParam("servicesId", servicesId)
                .when()
                .delete("/{servicesId}")
                .then()
                .statusCode(200);

        given()
                .pathParam("servicesId", servicesId)
                .when()
                .get("/{servicesId}")
                .then()
                .statusCode(404);
    }
}
