package com.maximalus.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "product_groups")
public class ProductGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_group_generator")
    @SequenceGenerator(allocationSize = 1, name = "product_group_generator")
    private Long id;

    @Column(nullable = false)
    private String nameOfProductsGroup;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> productList = new ArrayList<>();
}
