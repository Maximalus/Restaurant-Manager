package com.maximalus.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Embeddable
public class Recipe {
    @OneToOne
    private Ingredient ingredient;

    @Column(nullable = false)
    private double amountOfIngredient;

    public Recipe(Ingredient ingredient, double amountOfIngredient) {
        this.ingredient = ingredient;
        this.amountOfIngredient = amountOfIngredient;
    }
}
