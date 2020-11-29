package com.maximalus.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

//todo create foreign key

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="sales_reports")
public class SalesReport extends Report{
    @Column(nullable = false)
    private int numberOfUnPaidOrders;

    @Column(nullable = false)
    private int numberOfPaidOrders;

    @Column(nullable = false)
    private double totalSales;

    @Column(nullable = false)
    private double costOfIngredients;

    @Column(nullable = false)
    private double totalRevenue;

    public SalesReport(Outlet outlet, LocalDateTime creationDate, int numberOfUnPaidOrders, int numberOfPaidOrders, double totalSales, double costOfIngredients, double totalRevenue) {
        super(outlet, creationDate);
        this.numberOfUnPaidOrders = numberOfUnPaidOrders;
        this.numberOfPaidOrders = numberOfPaidOrders;
        this.totalSales = totalSales;
        this.costOfIngredients = costOfIngredients;
        this.totalRevenue = totalRevenue;
    }
}
