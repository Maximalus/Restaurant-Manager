package com.maximalus.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//todo create foreign key

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="id")
@ToString
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ElementCollection
    private List<Product> productList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "NUMBER_OF_CUSTOMERS")
    private int numberOfCustomers;

    @Column(name="NUMBER_OF_TABLE")
    private int numberOfTable;

    @Column(name="TIME_OF_CREATION")
    private LocalDateTime creationDate = LocalDateTime.now();

    @Column(name="TOTAL_COST")
    private double totalCost;

    @Column(name="IS_PAYED")
    private boolean isPayed = false;

    public Order(List<Product> productList,
                 User user,
                 int numberOfCustomers,
                 int numberOfTable,
                 LocalDateTime creationDate,
                 double totalCost,
                 boolean isPayed) {
        this.productList = productList;
        this.user = user;
        this.numberOfCustomers = numberOfCustomers;
        this.numberOfTable = numberOfTable;
        this.creationDate = creationDate;
        this.totalCost = totalCost;
        this.isPayed = isPayed;
    }

    public void addProducts(Product product){
        this.productList.add(product);
    }
}
