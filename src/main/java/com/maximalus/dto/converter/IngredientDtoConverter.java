package com.maximalus.dto.converter;

import com.maximalus.dto.IngredientDto;
import com.maximalus.model.Ingredient;
import com.maximalus.model.storage.Storage;

import java.time.LocalDateTime;

public class IngredientDtoConverter {
    public static Ingredient fromDto(IngredientDto ingredientDto){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDto.getName());
        ingredient.setCreationDate(LocalDateTime.now());
        ingredient.setChangingDate(LocalDateTime.now());
        return ingredient;
    }

    public static IngredientDto toDto(Storage storage){
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(storage.getIngredient().getId());
        ingredientDto.setName(storage.getIngredient().getName());
        ingredientDto.setNameOfUnit(storage.getUnitName());
        ingredientDto.setIngredientGroupName(storage.getIngredient().getIngredientGroup().getName());
        ingredientDto.setCreationDate(storage.getIngredient().getCreationDate());
        ingredientDto.setChangingDate(storage.getIngredient().getChangingDate());
        ingredientDto.setTotalPrice(storage.getTotalPrice().toString());
        ingredientDto.setCostPerUnit(storage.getCostPerUnit().toString());
        ingredientDto.setCurrentQuantity(storage.getCurrentQuantity().toString());
        ingredientDto.setInitialQuantity(storage.getInitialQuantity().toString());
        return ingredientDto;
    }
}
