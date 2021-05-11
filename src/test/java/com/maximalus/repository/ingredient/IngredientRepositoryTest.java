package com.maximalus.repository.ingredient;

import com.maximalus.TestData;
import com.maximalus.exception.NotFoundException;
import com.maximalus.exception.RestaurantManagerException;
import com.maximalus.model.product.ingredient.Ingredient;
import com.maximalus.repository.IngredientRepository;
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
        Assertions.assertThrows(NotFoundException.class, () -> {
            ingredientRepository.findById(7L).orElseThrow(() ->
                    new NotFoundException(String.format("Ingredient with id $s does not exist", 7L)));
        });
    }

    @Test
    void findAllIngredients(){
        List<Ingredient> expected = TestData.getListOfIngredients();
        List<Ingredient> actual = ingredientRepository.findAll();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void saveIngredient(){

    }
}
