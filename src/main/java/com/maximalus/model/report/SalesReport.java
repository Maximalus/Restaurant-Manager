package com.maximalus.model.report;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="sales_reports")
public class SalesReport extends Report{
    @Column(nullable = false)
    private int numberOfUnPaidOrders;

    @Column(nullable = false)
    private int numberOfPaidOrders;

    @Column(nullable = false)
    private BigDecimal totalSales;

    @Column(nullable = false)
    private BigDecimal costOfIngredients;

    @Column(nullable = false)
    private BigDecimal totalRevenue;
}
