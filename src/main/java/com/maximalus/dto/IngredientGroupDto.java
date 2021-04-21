package com.maximalus.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IngredientGroupDto {
    private Long id;
    private String name;
    private boolean isDeleted;
    private LocalDateTime creationDate;
    private LocalDateTime changingDate;
}
