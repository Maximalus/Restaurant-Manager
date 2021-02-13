package com.maximalus.repository;

import com.maximalus.model.Ingredient;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.maximalus.repository.TestData.getIngredient;
import static com.maximalus.repository.TestData.getIngredientForUpdate;
import static com.maximalus.repository.TestData.getListOfIngredients;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(initializers = {IngredientRepositoryIntegrationTest.Initializer.class})
public class IngredientRepositoryIntegrationTest {
    @Autowired
    private IngredientRepository ingredientRepository;

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {

        }
    }

    @Test
    @Order(1)
    public void testFindAllIngredients(){
        List<Ingredient> expectedIngredients = getListOfIngredients();
        List<Ingredient> actualIngredients = (List<Ingredient>) ingredientRepository.findAll();

        assertEquals(expectedIngredients, actualIngredients);
    }

    @Test
    @Order(2)
    public void testCreateIngredient(){
        Ingredient actualIngredient = getIngredient();
        Ingredient expectedIngredient = ingredientRepository.save(actualIngredient);

        assertEquals(expectedIngredient, actualIngredient);
    }

    @Test
    @Order(3)
    public void testFindByIdIngredient(){
        Ingredient actualIngredient = getIngredient();
        Ingredient expectedIngredient = ingredientRepository.findById(actualIngredient.getId()).orElseThrow();

        assertEquals(expectedIngredient, actualIngredient);
    }

    @Test
    @Order(4)
    public void testUpdateIngredient(){
        Ingredient expectedIngredient = getIngredientForUpdate();
        Ingredient actualIngredient = ingredientRepository.save(expectedIngredient);

        assertEquals(expectedIngredient, actualIngredient);
    }

    @Test
    @Order(5)
    public void testDeleteIngredient(){
        Long id = getIngredient().getId();
        ingredientRepository.deleteById(id);

        assertFalse(ingredientRepository.findById(id).isPresent());
    }
}
