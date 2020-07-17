package com.maximalus.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

//todo create foreign key

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "PRODUCT_GROUPS")
public class ProductGroup {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name="NAME_OF_PRODUCTS_GROUP")
    private String nameOfProductsGroup;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> productList = new ArrayList<>();

    public ProductGroup(String nameOfProductsGroup, List<Product> productList) {
        this.nameOfProductsGroup = nameOfProductsGroup;
        this.productList = productList;
    }
}
