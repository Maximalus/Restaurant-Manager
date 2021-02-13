package com.maximalus.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "outlets")
public class Outlet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "outlet_generator")
    @SequenceGenerator(allocationSize = 1, name = "outlet_generator")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orderList = new ArrayList<>();

    @Setter(AccessLevel.PRIVATE)
    @OneToMany
    private List<User> userList = new ArrayList<>();
}
