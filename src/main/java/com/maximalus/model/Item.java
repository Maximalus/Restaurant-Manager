package com.maximalus.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_generator")
    @SequenceGenerator(allocationSize = 1, name = "item_generator")
    private Long id;

    @EqualsAndHashCode.Exclude
    @OneToOne
    private Product product;

    @Column(nullable = false)
    private int orderedAmount;

    @EqualsAndHashCode.Exclude
    @OneToOne
    private ProductDiscount productDiscount;

    private BigDecimal totalCost;
}
