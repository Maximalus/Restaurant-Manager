package com.maximalus.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="id")
@ToString
@Entity
@Table(name="INGREDIENTS")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="NAME_OF_INGREDIENT")
    private String nameOfIngredient;

    @Column(name="CURRENT_AMOUNT")
    private double currentAmountOfIngredient;

    @Column(name="ORDERED_AMOUNT")
    private double orderedAmountOfIngredient;

    @Column(name="COST_PER_UNIT")
    private double costPerUnit;

    @Column(name="TOTAL_PRICE")
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
