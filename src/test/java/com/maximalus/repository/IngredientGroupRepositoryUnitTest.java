package com.maximalus.repository;

import com.maximalus.exception.RestaurantManagerException;
import com.maximalus.model.IngredientGroup;
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

import static com.maximalus.repository.TestData.getIngredientGroup;
import static com.maximalus.repository.TestData.getIngredientGroupForUpdate;
import static com.maximalus.repository.TestData.getListOfIngredientGroups;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ContextConfiguration(initializers = {IngredientGroupRepositoryUnitTest.Initializer.class})
public class IngredientGroupRepositoryUnitTest {
    @Autowired
    private IngredientGroupRepository ingredientGroupRepository;

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {

        }
    }

    @Test
    @Order(1)
    public void testFindAllIngredients(){
        List<IngredientGroup> expectedIngredientGroups = getListOfIngredientGroups();
        List<IngredientGroup> actualIngredientGroups= (List<IngredientGroup>) ingredientGroupRepository.findAll();

        assertEquals(expectedIngredientGroups, actualIngredientGroups);
    }

    @Test
    @Order(2)
    public void testCreateIngredientGroups(){
        IngredientGroup actualIngredientGroup = getIngredientGroup();
        IngredientGroup expectedIngredientGroup = ingredientGroupRepository.save(actualIngredientGroup);

        assertEquals(actualIngredientGroup, expectedIngredientGroup);
    }

    @Test
    @Order(3)
    public void testFindByIdIngredientGroup(){
        IngredientGroup actualIngredientGroup = getIngredientGroup();
        IngredientGroup expectedIngredientGroup =
                ingredientGroupRepository.findById(actualIngredientGroup.getId())
                        .orElseThrow(() -> new RestaurantManagerException(String.format("Ingredient group with %d does not exist", actualIngredientGroup.getId())));

        assertEquals(actualIngredientGroup, expectedIngredientGroup);
    }

    @Test
    @Order(4)
    public void testUpdateIngredientGroup(){
        IngredientGroup expectedIngredientGroup = getIngredientGroupForUpdate();
        IngredientGroup actualIngredientGroup = ingredientGroupRepository.save(expectedIngredientGroup);

        assertEquals(expectedIngredientGroup, actualIngredientGroup);
    }

    @Test
    @Order(5)
    public void testDeleteIngredientGroup(){
        Long id = getIngredientGroup().getId();
        ingredientGroupRepository.deleteById(id);

        assertFalse(ingredientGroupRepository.findById(id).isPresent());
    }

}
