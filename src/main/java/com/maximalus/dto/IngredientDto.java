package com.maximalus.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

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
    private LocalDateTime creationDate;
    private LocalDateTime changingDate;
}
