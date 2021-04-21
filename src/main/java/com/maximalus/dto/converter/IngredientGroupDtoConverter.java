package com.maximalus.dto.converter;

import com.maximalus.dto.IngredientGroupDto;
import com.maximalus.model.product.ingredient.IngredientGroup;

public class IngredientGroupDtoConverter {
    public static IngredientGroupDto toDto(IngredientGroup ingredientGroup){
        IngredientGroupDto ingredientGroupDto = new IngredientGroupDto();
        ingredientGroupDto.setId(ingredientGroup.getId());
        ingredientGroupDto.setName(ingredientGroup.getName());
        ingredientGroupDto.setDeleted(ingredientGroup.isDeleted());
        ingredientGroupDto.setCreationDate(ingredientGroup.getCreationDate());
        ingredientGroupDto.setChangingDate(ingredientGroup.getChangingDate());
        return ingredientGroupDto;
    }
}
