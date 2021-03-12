package com.maximalus.repository;

import com.maximalus.TestData;
import com.maximalus.model.Ingredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IngredientRepositoryTest {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void findById(){
        Ingredient expected = TestData.getIngredient();
        Ingredient actual = ingredientRepository.findById(expected.getId()).orElse(null);

        Assertions.assertEquals(expected, actual);
    }
}
