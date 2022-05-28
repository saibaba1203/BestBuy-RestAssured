package com.studentapp.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;


public class TestBaseForServices {

    @BeforeClass
    public static void initialize(){
        RestAssured.baseURI="http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/services";
    }
}
