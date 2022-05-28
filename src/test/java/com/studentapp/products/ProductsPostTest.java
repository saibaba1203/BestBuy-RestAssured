package com.studentapp.products;


import com.studentapp.model.ProductPojo;
import com.studentapp.testbase.TestBaseForProducts;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class ProductsPostTest extends TestBaseForProducts {

    @Test
    public void createNewProduct(){

        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Apple iPad pro 512 GB");
        productPojo.setType("HardGood");
        productPojo.setPrice(899);
        productPojo.setShipping(20);
        productPojo.setUpc("123433429874");
        productPojo.setDescription("Apple iPad pro 512GB - Silver");
        productPojo.setManufacturer("Apple");
        productPojo.setModel("iPad");
        productPojo.setUrl("This is url for iPad Pro");
        productPojo.setImage("This is image for iPad Pro");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }
}

/*
9999685 - iphone
9999687 - ipad
9999688 - ipad 1tb
 */