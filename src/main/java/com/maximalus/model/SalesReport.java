package com.maximalus.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
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
}
