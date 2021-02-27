package com.maximalus.model;

import com.maximalus.model.discount.CompanyDiscount;
import com.maximalus.model.discount.DiscountProof;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
    @SequenceGenerator(allocationSize = 1, name = "order_generator")
    private Long id;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @EqualsAndHashCode.Exclude
    @OneToMany
    private List<Item> items = new ArrayList<>();

    @Column(nullable = false)
    private int numberOfCustomers;

    @Column(nullable = false)
    private int numberOfTable;

    @Column(nullable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    @EqualsAndHashCode.Exclude
    @OneToOne
    private CompanyDiscount companyDiscount;

    @EqualsAndHashCode.Exclude
    @OneToOne
    private DiscountProof discountProof;

    @Column(nullable = false)
    private BigDecimal totalCost;

    @Column(nullable = false)
    private boolean isPayed = false;
}
