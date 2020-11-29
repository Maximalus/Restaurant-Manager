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
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> itemList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(nullable = false)
    private int numberOfCustomers;

    @Column(nullable = false)
    private int numberOfTable;

    private LocalDateTime creationDate = LocalDateTime.now();

    @Column(nullable = false)
    private double totalCost;

    @Column(nullable = false)
    private boolean isPayed = false;

    public Order(List<Item> itemList, User user,
                 int numberOfCustomers, int numberOfTable,
                 LocalDateTime creationDate, double totalCost,
                 boolean isPayed) {
        this.itemList = itemList;
        this.user = user;
        this.numberOfCustomers = numberOfCustomers;
        this.numberOfTable = numberOfTable;
        this.creationDate = creationDate;
        this.totalCost = totalCost;
        this.isPayed = isPayed;
    }

    public void addItem(Item item){
        itemList.add(item);
        item.setOrder(this);
    }

    public void removeItem(Item item){
        itemList.remove(item);
        item.setOrder(null);
    }
}
