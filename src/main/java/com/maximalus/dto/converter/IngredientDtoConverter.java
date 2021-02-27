package com.maximalus.dto.converter;

import com.maximalus.dto.IngredientDto;
import com.maximalus.model.Ingredient;

import java.math.BigDecimal;
import java.time.LocalDate;

public class IngredientDtoConverter {
    public static Ingredient fromDto(IngredientDto ingredientDto){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientDto.getName());

        String costPerUnit = ingredientDto.getCostPerUnit();
        Long parseLong = Long.parseLong(costPerUnit);

        ingredient.setCostPerUnit(BigDecimal.valueOf(parseLong));
        ingredient.setCurrentQuantity(BigDecimal.ZERO);
        ingredient.setInitialQuantity(BigDecimal.ZERO);
        ingredient.setUnitName(ingredientDto.getNameOfUnit());
        ingredient.setCreationDate(LocalDate.now());
        ingredient.setChangingDate(LocalDate.now());
        ingredient.setTotalPrice(BigDecimal.ZERO);
        return ingredient;
    }

    public static IngredientDto toDto(Ingredient ingredient){
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setNameOfUnit(ingredient.getUnitName());
        ingredientDto.setIngredientGroupName(ingredient.getIngredientGroup().getName());
        ingredientDto.setCreationDate(ingredient.getCreationDate());
        ingredientDto.setChangingDate(ingredient.getChangingDate());
        ingredientDto.setTotalPrice(ingredient.getTotalPrice().toString());
        ingredientDto.setCostPerUnit(ingredient.getCostPerUnit().toString());
        ingredientDto.setCurrentQuantity(ingredient.getCurrentQuantity().toString());
        ingredientDto.setInitialQuantity(ingredient.getInitialQuantity().toString());
        return ingredientDto;
    }
}
