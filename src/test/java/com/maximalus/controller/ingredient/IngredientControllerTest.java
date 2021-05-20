package com.maximalus.controller.ingredient;

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
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
        Ingredient ingredient = TestData.getListOfIngredients().get(0);
        IngredientGroup ingredientGroup = ingredientGroupService.findById(4L);
        ingredient.setIngredientGroup(ingredientGroup);
        IngredientDto expected = IngredientDtoConverter.toDto(ingredient);

        IngredientDto actual = ingredientController.getIngredientById(1L);

        Assertions.assertEquals(expected, actual);
    }
}
