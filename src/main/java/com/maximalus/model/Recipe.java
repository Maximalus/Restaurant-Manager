package com.maximalus.model;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
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

    @Column(name="AMOUNT_OF_INGREDIENT")
    private double amountOfIngredient;

    public Recipe(Ingredient ingredient, double amountOfIngredient) {
        this.ingredient = ingredient;
        this.amountOfIngredient = amountOfIngredient;
    }
}
