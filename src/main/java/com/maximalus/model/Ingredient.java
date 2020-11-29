package com.maximalus.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name="ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public Ingredient(String nameOfIngredient, double currentAmountOfIngredient, double orderedAmountOfIngredient, double costPerUnit, double totalPrice, IngredientGroup ingredientGroup) {
        this.nameOfIngredient = nameOfIngredient;
        this.currentAmountOfIngredient = currentAmountOfIngredient;
        this.orderedAmountOfIngredient = orderedAmountOfIngredient;
        this.costPerUnit = costPerUnit;
        this.totalPrice = totalPrice;
        this.ingredientGroup = ingredientGroup;
    }
}
