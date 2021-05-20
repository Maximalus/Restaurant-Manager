package com.maximalus.service.ingredient;

import com.maximalus.TestData;
import com.maximalus.model.product.ingredient.Ingredient;
import com.maximalus.repository.IngredientRepository;
import com.maximalus.service.impl.IngredientServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IngredientServiceTest {
    private IngredientRepository ingredientRepository = mock(IngredientRepository.class);
    private IngredientServiceImpl ingredientService = new IngredientServiceImpl(ingredientRepository);

    @Test
    public void findAllIngredients(){
        when(ingredientRepository.findAll()).thenReturn(TestData.getListOfIngredients());

        List<Ingredient> actual = ingredientService.findAll();
        List<Ingredient> expected = TestData.getListOfIngredients();

        assertEquals(expected, actual);
    }

    @Test
    public void findIngredientById(){
        Ingredient expected = TestData.getListOfIngredients().get(1);

        when(ingredientRepository.findById(1L)).thenReturn(Optional.ofNullable(expected));

        Ingredient actual = ingredientService.findById(1L);


        assertEquals(expected, actual);
    }

    @Test
    public void saveIngredient(){
        Ingredient expected = TestData.getIngredientForSaving();

        when(ingredientRepository.save(expected)).thenReturn(expected);

        Ingredient actual = ingredientService.save(expected);

        assertEquals(expected, actual);
    }

    @Test
    public void updateIngredient(){
        Ingredient expected = TestData.getIngredientForUpdate();

        when(ingredientRepository.save(expected)).thenReturn(expected);

        Ingredient actual = ingredientService.save(expected);


        assertEquals(expected, actual);
    }


}
