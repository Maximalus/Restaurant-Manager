package com.maximalus.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

//todo create foreign key

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="SALES_REPORTS")
public class SalesReport extends Report{
    @Column(name="NUMBERS_OF_UNPAID_ORDERS")
    private int numberOfUnPaidOrders;

    @Column(name="NUMBER_OF_PAID_ORDERS")
    private int numberOfPaidOrders;

    @Column(name="TOTAL_SALES")
    private double totalSales;

    @Column(name="COST_OF_INGREDIENTS")
    private double costOfIngredients;

    @Column(name="TOTAL_REVENUE")
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
