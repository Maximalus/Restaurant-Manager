package com.maximalus.model.storage;

import com.maximalus.model.product.ingredient.Ingredient;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ingredient_storage")
public class IngredientStorage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_storage_generator")
    @SequenceGenerator(allocationSize = 1, name = "ingredient_storage_generator")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Column(nullable = false)
    private String unitName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "storage_type_id")
    private StorageType storageType;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal currentQuantity;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal initialQuantity;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal costPerUnit;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column(nullable = false)
    private LocalDateTime changingDate;

    @Column(nullable = false)
    private boolean isDeleted;
}
