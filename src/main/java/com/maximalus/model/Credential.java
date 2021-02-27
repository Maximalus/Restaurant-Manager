package com.maximalus.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CREDENTIALS")
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_generator")
    @SequenceGenerator(allocationSize = 1, name = "item_generator")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    private Role role;

    public Credential(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
