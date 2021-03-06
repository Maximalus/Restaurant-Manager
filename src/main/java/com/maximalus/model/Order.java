package com.maximalus.model;

import com.maximalus.model.discount.CompanyDiscount;
import com.maximalus.model.discount.DiscountProof;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
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
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany
    private List<Item> items = new ArrayList<>();

    @Min(value = 0, message = "Number of customers should be greater than 0")
    @Column(nullable = false)
    private int numberOfCustomers;

    @Min(value = 0, message = "Number of table should be greater than 0")
    @Column(nullable = false)
    private int numberOfTable;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime changingDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    private CompanyDiscount companyDiscount;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne
    private DiscountProof discountProof;

    @Column(nullable = false)
    private BigDecimal totalCost;

    @Column(nullable = false)
    private boolean isPayed;

    @Column(nullable = false)
    private boolean isDeleted;
}
