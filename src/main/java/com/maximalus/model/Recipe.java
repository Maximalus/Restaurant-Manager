package com.maximalus.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Data
@Embeddable
public class Recipe {
    @OneToOne
    private Ingredient ingredient;

    @Column(nullable = false)
    private double amountOfIngredient;
}
