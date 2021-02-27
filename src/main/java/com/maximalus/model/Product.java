package com.maximalus.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(allocationSize = 1, name = "product_generator")
    private Long id;

    @Column(nullable = false)
    private String nameOfProduct;

    @Column(nullable = false)
    private BigDecimal pricePerUnit;

    @Column(nullable = false)
    private int markupPercentage;

    @Column(nullable = false)
    private int availableQuantity;

    @EqualsAndHashCode.Exclude
    @ElementCollection
    private List<Recipe> recipeList = new ArrayList<>();

    @Column(nullable = false)
    private boolean isDeleted;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime changingDate;

}
