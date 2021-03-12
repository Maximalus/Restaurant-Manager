package com.maximalus.service;

import com.maximalus.TestData;
import com.maximalus.model.Ingredient;
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
    public void getAllIngredients(){
        when(ingredientRepository.findAll()).thenReturn(TestData.getListOfIngredients());

        List<Ingredient> actual = ingredientService.findAll();
        List<Ingredient> expected = TestData.getListOfIngredients();

        assertEquals(expected, actual);
    }

    @Test
    public void getIngredient(){
        when(ingredientRepository.findById(6L)).thenReturn(Optional.of(TestData.getIngredient()));

        Ingredient actual = ingredientService.findById(6L);
        Ingredient expected = TestData.getIngredient();

        assertEquals(expected, actual);
    }

    @Test
    public void saveIngredient(){
        when(ingredientRepository.save(TestData.getIngredient())).thenReturn(TestData.getIngredient());

        Ingredient actual = ingredientService.save(TestData.getIngredient());
        Ingredient expected = TestData.getIngredient();

        assertEquals(expected, actual);
    }

    @Test
    public void updateIngredient(){
        when(ingredientRepository.save(TestData.getIngredientForUpdate())).thenReturn(TestData.getIngredientForUpdate());

        Ingredient actual = ingredientService.save(TestData.getIngredientForUpdate());
        Ingredient expected = TestData.getIngredientForUpdate();

        assertEquals(expected, actual);
    }
}
