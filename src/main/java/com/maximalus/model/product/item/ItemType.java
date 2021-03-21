package com.maximalus.model.product.item;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Entity
@Table(name="item_types")
public class ItemType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_type_generator")
    @SequenceGenerator(allocationSize = 1, name = "item_type_generator")
    private Long id;

    @Column(nullable = false)
    private String name;
}
