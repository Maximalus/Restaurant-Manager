package com.maximalus.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class IngredientStorageDto {
    private String nameOfIngredient;
    private BigDecimal costPerUnit;
    private String ingredientGroupName;
    private BigDecimal currentQuantity;
    private BigDecimal initialQuantity;
    private BigDecimal totalPrice;
    private String storageType;
    private LocalDateTime creationDate;
    private LocalDateTime changingDate;
}
