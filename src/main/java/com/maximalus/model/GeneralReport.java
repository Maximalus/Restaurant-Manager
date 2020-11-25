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
@Table(name="GENERAL_REPORTS")
public class GeneralReport extends Report{
    @Column(name="NUMBER_OF_ORDERS")
    private int numberOfOrders;

    @Column(name = "NUMBER_OF_CUSTOMERS")
    private int numberOfCustomers;

    @Column(name="NUMBERS_OF_UNPAID_ORDERS")
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
