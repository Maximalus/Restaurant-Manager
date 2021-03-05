package com.maximalus.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "credentials")
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credentials_generator")
    @SequenceGenerator(allocationSize = 2, name = "credentials_generator")
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Role role;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime changingDate;

    @Column(nullable = false)
    private boolean isDeleted;

    public Credential(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
