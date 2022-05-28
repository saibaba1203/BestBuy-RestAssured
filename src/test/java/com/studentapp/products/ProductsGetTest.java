package com.studentapp.products;


import com.studentapp.testbase.TestBaseForProducts;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class ProductsGetTest extends TestBaseForProducts {

    @Test
    public void getAllProductsInfo(){
        Response response = given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleProductByid(){
        Response response = given()
                .pathParam("id",43900)
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    // with Hashmap
    @Test
    public void getProductsLimitToResult(){
        HashMap<String, Object> qParams = new HashMap<>();
        qParams.put("limit", "3");

        Response response = given()
                .queryParams(qParams)
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getProductsByLimit(){
        Response response = given()
                .pathParam("limit", 3)
                .when()
                .get("/{limit}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
