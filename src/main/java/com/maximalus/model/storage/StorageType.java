package com.maximalus.model.storage;

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
@Table(name="storage_type")
public class StorageType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "storage_type_generator")
    @SequenceGenerator(allocationSize = 1, name = "storage_type_generator")
    private Long id;

    @Column(nullable = false)
    private String name;
}
