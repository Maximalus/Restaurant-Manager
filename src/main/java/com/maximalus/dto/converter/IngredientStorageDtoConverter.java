package com.maximalus.dto.converter;

import com.maximalus.dto.IngredientStorageDto;
import com.maximalus.model.storage.IngredientStorage;

public class IngredientStorageDtoConverter {
    public static IngredientStorage fromDto(IngredientStorageDto ingredientStorageDto){
        IngredientStorage ingredientStorage = new IngredientStorage();

        return ingredientStorage;
    }

    public static IngredientStorageDto toDto(IngredientStorage ingredientStorage){
        IngredientStorageDto ingredientStorageDto = new IngredientStorageDto();
        ingredientStorageDto.setNameOfIngredient(ingredientStorage.getIngredient().getName());
        ingredientStorageDto.setCostPerUnit(ingredientStorage.getCostPerUnit());
        ingredientStorageDto.setInitialQuantity(ingredientStorage.getInitialQuantity());
        ingredientStorageDto.setCurrentQuantity(ingredientStorage.getCurrentQuantity());
        ingredientStorageDto.setTotalPrice(ingredientStorage.getTotalPrice());
        ingredientStorageDto.setCreationDate(ingredientStorage.getCreationDate());
        ingredientStorageDto.setChangingDate(ingredientStorage.getChangingDate());

        return ingredientStorageDto;
    }
}
