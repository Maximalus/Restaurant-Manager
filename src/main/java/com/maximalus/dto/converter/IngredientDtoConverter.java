package com.maximalus.dto.converter;

import com.maximalus.dto.IngredientDto;
import com.maximalus.model.product.ingredient.Ingredient;
import com.maximalus.model.storage.IngredientStorage;

import java.time.LocalDateTime;

public class IngredientDtoConverter {
    public static Ingredient fromDto(IngredientDto ingredientDto){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDto.getName());
        ingredient.setUnitName(ingredientDto.getNameOfUnit());
        ingredient.setCreationDate(LocalDateTime.now());
        ingredient.setChangingDate(LocalDateTime.now());
        return ingredient;
    }
}
