package com.maximalus.dto.converter;

import com.maximalus.dto.IngredientDto;
import com.maximalus.model.product.ingredient.Ingredient;
import com.maximalus.model.storage.IngredientStorage;

import java.time.LocalDateTime;

public class IngredientDtoConverter {
    public static Ingredient fromDto(IngredientDto ingredientDto){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDto.getName());
        ingredient.setCreationDate(LocalDateTime.now());
        ingredient.setChangingDate(LocalDateTime.now());
        return ingredient;
    }

    public static IngredientDto toDto(IngredientStorage ingredientStorage){
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(ingredientStorage.getIngredient().getId());
        ingredientDto.setName(ingredientStorage.getIngredient().getName());
        ingredientDto.setNameOfUnit(ingredientStorage.getUnitName());
        ingredientDto.setIngredientGroupName(ingredientStorage.getIngredient().getIngredientGroup().getName());
        ingredientDto.setCreationDate(ingredientStorage.getIngredient().getCreationDate());
        ingredientDto.setChangingDate(ingredientStorage.getIngredient().getChangingDate());
        ingredientDto.setTotalPrice(ingredientStorage.getTotalPrice().toString());
        ingredientDto.setCostPerUnit(ingredientStorage.getCostPerUnit().toString());
        ingredientDto.setCurrentQuantity(ingredientStorage.getCurrentQuantity().toString());
        ingredientDto.setInitialQuantity(ingredientStorage.getInitialQuantity().toString());
        return ingredientDto;
    }
}
