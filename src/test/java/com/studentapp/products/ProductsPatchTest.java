package com.studentapp.products;

import com.studentapp.model.ProductPojo;
import com.studentapp.testbase.TestBaseForProducts;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class ProductsPatchTest extends TestBaseForProducts {

    @Test
    public void updateProductWithPatch() {
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Apple iPad pro 1 TB");
        productPojo.setType("HardGood");
        productPojo.setPrice(899);
        productPojo.setShipping(0);
        productPojo.setUpc("456733429874");
        productPojo.setDescription("Apple iPad pro 1TB - Silver");
        productPojo.setManufacturer("Apple");
        productPojo.setModel("iPad");
        productPojo.setUrl("This is url for iPad Pro 1 TB");
        productPojo.setImage("This is image for iPad Pro 1 TB");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", "9999687")
                .body(productPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }


}
