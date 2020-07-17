package com.maximalus.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
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
    private int numberOfUnPaidOrders;

    public GeneralReport(Outlet outlet, LocalDateTime creationDate, int numberOfOrders, int numberOfCustomers, int numberOfUnPaidOrders) {
        super(outlet, creationDate);
        this.numberOfOrders = numberOfOrders;
        this.numberOfCustomers = numberOfCustomers;
        this.numberOfUnPaidOrders = numberOfUnPaidOrders;
    }
}
