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

    private BigDecimal totalPrice;

    private LocalDate creationDate = LocalDate.now();

    private LocalDate changingDate;

    @Column(nullable = false)
    private BigDecimal costPerUnit;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private IngredientGroup ingredientGroup;
}
