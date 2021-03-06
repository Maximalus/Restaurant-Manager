package com.maximalus.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Data
@Embeddable
public class Recipe {
    @OneToOne
    private Ingredient ingredient;

    @Column(nullable = false)
    private double amountOfIngredient;

    @Column(nullable = false)
    private boolean isDeleted;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime changingDate;

}
