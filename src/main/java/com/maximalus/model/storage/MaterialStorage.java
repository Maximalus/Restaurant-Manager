package com.maximalus.model.storage;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "material_storage")
public class MaterialStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_storage_generator")
    @SequenceGenerator(allocationSize = 1, name = "material_storage_generator")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String unitName;

    @Column(nullable = false)
    private int initialAmount;

    @Column(nullable = false)
    private int currentAmount;

    @Column(nullable = false)
    private BigDecimal pricePerOne;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime changingDate;

    @Column(nullable = false)
    private boolean isDeleted;
}
