package com.maximalus.dto;

import lombok.Data;

@Data
public class IngredientDto {
    private Long id;
    private String name;
    private String costPerUnit;
    private String nameOfUnit;
    private String ingredientGroupName;
}
