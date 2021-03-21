package com.maximalus.repository;

import com.maximalus.TestData;
import com.maximalus.exception.RestaurantManagerException;
import com.maximalus.model.product.ingredient.Ingredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.util.Assert;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IngredientRepositoryTest {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void findIngredientById(){
        Ingredient expected = TestData.getIngredient();
        Ingredient actual = ingredientRepository.findById(expected.getId()).orElse(null);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findIngredientByIdThrowsException(){
        Assertions.assertThrows(RestaurantManagerException.class, () -> {
            ingredientRepository.findById(7L).orElseThrow(() ->
                    new RestaurantManagerException(String.format("Ingredient with id $s does not exist", 7L)));
        });
    }

    @Test
    void findAllIngredients(){
        List<Ingredient> expected = TestData.getListOfIngredients();
        List<Ingredient> actual = (List<Ingredient>) ingredientRepository.findAll();

        Assertions.assertEquals(expected, actual);
    }

    void saveIngredient(){

    }
}
