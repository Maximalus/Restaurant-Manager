package com.maximalus.controller;

import com.maximalus.TestData;
import com.maximalus.controler.IngredientController;
import com.maximalus.dto.IngredientDto;
import com.maximalus.dto.converter.IngredientDtoConverter;
import com.maximalus.model.product.ingredient.Ingredient;
import com.maximalus.model.product.ingredient.IngredientGroup;
import com.maximalus.service.impl.IngredientGroupServiceImpl;
import com.maximalus.service.impl.IngredientServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IngredientControllerTest {
    @Autowired
    private IngredientController ingredientController;

    @Autowired
    private IngredientServiceImpl ingredientService;

    @Autowired
    private IngredientGroupServiceImpl ingredientGroupService;

    @Test
    public void findIngredientById(){
        Ingredient ingredient = TestData.getIngredient();
        IngredientGroup ingredientGroup = ingredientGroupService.findById(4L);
        ingredient.setIngredientGroup(ingredientGroup);
        IngredientDto expected = IngredientDtoConverter.toDto(ingredient);

        IngredientDto actual = ingredientController.getIngredientById(1L);

        Assertions.assertEquals(expected, actual);
    }
}
