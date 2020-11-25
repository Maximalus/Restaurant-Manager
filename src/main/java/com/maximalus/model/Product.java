package com.maximalus.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//todo create foreign key

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nameOfProduct;
    private double costPerUnit;
    private int numberOfServings;
    private double totalPrice;
    private int availableQuantity;

    @ElementCollection
    private List<Recipe> recipeList = new ArrayList<>();

    public Product(String nameOfProduct, double costPerUnit, int numberOfServings, double totalPrice, int availableQuantity, List<Recipe> recipeList) {
        this.nameOfProduct = nameOfProduct;
        this.costPerUnit = costPerUnit;
        this.numberOfServings = numberOfServings;
        this.totalPrice = totalPrice;
        this.availableQuantity = availableQuantity;
        this.recipeList = recipeList;
    }
}
