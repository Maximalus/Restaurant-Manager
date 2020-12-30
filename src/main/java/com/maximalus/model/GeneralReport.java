package com.maximalus.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="general_reports")
public class GeneralReport extends Report{
    @Column(nullable = false)
    private int numberOfOrders;

    @Column(nullable = false)
    private int numberOfCustomers;

    @Column(nullable = false)
    private int numberOfUnpaidOrders;

    public GeneralReport(Outlet outlet,
                         LocalDateTime creationDate,
                         int numberOfOrders,
                         int numberOfCustomers,
                         int numberOfUnpaidOrders) {
        super(outlet, creationDate);
        this.numberOfOrders = numberOfOrders;
        this.numberOfCustomers = numberOfCustomers;
        this.numberOfUnpaidOrders = numberOfUnpaidOrders;
    }
}