package com.studentapp.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;


public class TestBaseForCategories {

    @BeforeClass
    public static void initialize() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath = "/categories";

    }
}
