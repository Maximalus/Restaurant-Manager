package com.maximalus.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

//todo create foreign key

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "reports")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Outlet outlet;

    @Column(nullable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    public Report(Outlet outlet, LocalDateTime creationDate) {
        this.outlet = outlet;
        this.creationDate = creationDate;
    }
}
