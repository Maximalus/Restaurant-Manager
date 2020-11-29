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
@Table(name = "outlets")
public class Outlet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nameOfOutlet;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orderList = new ArrayList<>();

    @Setter(AccessLevel.PRIVATE)
    @OneToMany
    private List<User> userList = new ArrayList<>();

    public Outlet(String nameOfOutlet, List<Order> orderList, List<User> userList) {
        this.nameOfOutlet = nameOfOutlet;
        this.orderList = orderList;
        this.userList = userList;
    }
}
