package com.maximalus.model.report;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="general_reports")
public class GeneralReport extends Report{
    @Column(nullable = false)
    private int numberOfOrders;

    @Column(nullable = false)
    private int numberOfCustomers;

    @Column(nullable = false)
    private int numberOfUnpaidOrders;
}
