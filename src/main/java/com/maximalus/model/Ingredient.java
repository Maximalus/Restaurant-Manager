package com.maximalus.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name="ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_generator")
    @SequenceGenerator(allocationSize = 1, name = "ingredient_generator")
    private Long id;

    @Column(nullable = false)
    private String nameOfIngredient;

    @Column(nullable = false)
    private double currentAmountOfIngredient;

    @Column(nullable = false)
    private double orderedAmountOfIngredient;

    @Column(nullable = false)
    private double costPerUnit;

    @Column(nullable = false)
    private double totalPrice;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private IngredientGroup ingredientGroup;
}
