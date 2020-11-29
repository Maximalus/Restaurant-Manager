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
@Table(name = "product_groups")
public class ProductGroup {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nameOfProductsGroup;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> productList = new ArrayList<>();

    public ProductGroup(String nameOfProductsGroup, List<Product> productList) {
        this.nameOfProductsGroup = nameOfProductsGroup;
        this.productList = productList;
    }
}
