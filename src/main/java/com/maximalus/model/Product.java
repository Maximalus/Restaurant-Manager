package com.maximalus.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//todo create foreign key

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nameOfProduct;

    @Column(nullable = false)
    private double costPerUnit;

    @Column(nullable = false)
    private int availableQuantity;

    @ElementCollection
    private List<Recipe> recipeList = new ArrayList<>();

    public Product(String nameOfProduct, double costPerUnit,
                   int availableQuantity, List<Recipe> recipeList) {
        this.nameOfProduct = nameOfProduct;
        this.costPerUnit = costPerUnit;
        this.availableQuantity = availableQuantity;
        this.recipeList = recipeList;
    }
}
