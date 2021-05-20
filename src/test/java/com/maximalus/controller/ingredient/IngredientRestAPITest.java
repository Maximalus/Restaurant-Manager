package com.maximalus.controller.ingredient;

import com.maximalus.repository.IngredientRepository;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IngredientRestAPITest {
    @LocalServerPort
    private int port;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Test
    public void findById(){
        RestAssured
                .given()
                .port(port)
                .when().get("/api/v1/ingredients/{id}", 1)
                .then()
                .statusCode(200)
                .body("name", Matchers.equalTo("Grapefruit juice"))
                .body("unitName", Matchers.equalTo("Liter"));
    }
}
