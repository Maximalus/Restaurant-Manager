package com.maximalus.dto.converter;

import com.maximalus.dto.IngredientDto;
import com.maximalus.model.product.ingredient.Ingredient;
import com.maximalus.model.storage.IngredientStorage;

import java.time.LocalDateTime;
import java.util.List;

public class IngredientDtoConverter {
    public static Ingredient fromDto(IngredientDto ingredientDto){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDto.getName());
        ingredient.setUnitName(ingredientDto.getUnitName());
        ingredient.setCreationDate(LocalDateTime.now());
        ingredient.setChangingDate(LocalDateTime.now());
        return ingredient;
    }

    public static IngredientDto toDto(Ingredient ingredient){
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setUnitName(ingredient.getUnitName());
        ingredientDto.setIngredientGroupName(ingredient.getIngredientGroup().getName());
        ingredientDto.setCreationDate(ingredient.getCreationDate());
        ingredientDto.setChangingDate(ingredient.getChangingDate());
        return ingredientDto;
    }
}
