package com.maximalus.model.discount;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "company_discounts")
public class CompanyDiscount{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discount_generator")
    @SequenceGenerator(allocationSize = 1, name = "discount_generator")
    private Long id;

    @Column(nullable = false)
    private String discountName;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private LocalDate dateOfCreation = LocalDate.now();

    private LocalDate dateOfChange;

    @Column(nullable = false)
    private int percentageDiscount;
}
