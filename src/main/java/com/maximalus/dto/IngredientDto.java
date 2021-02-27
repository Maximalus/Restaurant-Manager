package com.maximalus.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class IngredientDto {
    private Long id;
    private String name;
    private String costPerUnit;
    private String nameOfUnit;
    private String ingredientGroupName;
    private String currentQuantity;
    private String initialQuantity;
    private String totalPrice;
    private LocalDate creationDate;
    private LocalDate changingDate;
}
