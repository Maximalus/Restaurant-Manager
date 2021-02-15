package com.maximalus.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name="ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_generator")
    @SequenceGenerator(allocationSize = 1, name = "ingredient_generator")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int currentQuantity;

    @Column(nullable = false)
    private int initialQuantity;

    @Column(nullable = false)
    private String unitName;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalPrice;

    private LocalDate creationDate;

    private LocalDate changingDate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal costPerUnit;

    @ManyToOne(cascade = CascadeType.ALL)
    private IngredientGroup ingredientGroup;

    public void setIngredientGroup(IngredientGroup ingredientGroup){
        ingredientGroup.addIngredient(this);
    }

    public void removeIngredientGroup(IngredientGroup ingredientGroup){
        ingredientGroup.removeIngredient(this);
    }
}
