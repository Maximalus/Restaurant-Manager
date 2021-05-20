package com.maximalus.controller.ingredient;

import com.maximalus.controler.IngredientController;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.maximalus.repository.IngredientRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IngredientRestAPITest {
    @LocalServerPort
    private int port;

    @Autowired
    private IngredientRepository ingredientRepository;

    //Spring security has to be disable before running this test
    @Test
    @Disabled
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
