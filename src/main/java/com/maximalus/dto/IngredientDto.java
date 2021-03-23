package com.maximalus.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IngredientDto {
    private Long id;
    private String name;
    private String unitName;
    private String ingredientGroupName;
    private LocalDateTime creationDate;
    private LocalDateTime changingDate;
}
