package com.maximalus.service.impl;

import com.maximalus.model.report.GeneralReport;
import com.maximalus.model.Ingredient;
import com.maximalus.model.Order;
import com.maximalus.model.report.SalesReport;
import com.maximalus.repository.IngredientRepository;
import com.maximalus.repository.OutletRepository;
import com.maximalus.repository.ReportRepository;
import com.maximalus.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    private ReportRepository reportRepository;
    private OutletRepository outletRepository;
    private IngredientRepository ingredientRepository;

    private List<Order> orderList = new ArrayList<>();
    private List<Ingredient> ingredientList = new ArrayList<>();

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository, OutletRepository outletRepository, IngredientRepository ingredientRepository) {
        this.reportRepository = reportRepository;
        this.outletRepository = outletRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public void save(GeneralReport generalReport, long outletId){
        getAllOrders(outletId);
        int numberOfCustomers = getNumberOfCustomers(orderList);
        int numberOfOrders = getNumberOfOrders(orderList);
        int numberOfUnPaidOrders = getNumberOfUnPaidOrders(orderList);
        generalReport.setOutlet(outletRepository.findById(outletId).orElseThrow());
        generalReport.setNumberOfCustomers(numberOfCustomers);
        generalReport.setNumberOfOrders(numberOfOrders);
        generalReport.setNumberOfUnpaidOrders(numberOfUnPaidOrders);
        reportRepository.save(generalReport);
    }

    public void save(SalesReport salesReport, long outletId){
        getAllOrders(outletId);
        getAllIngredients();
        int numberOfPaidOrders = getNumberOfPaidOrders(orderList);
        int numberOfUnPaidOrders = getNumberOfUnPaidOrders(orderList);
        BigDecimal costOfIngredients = getCostOfIngredients(ingredientList);
        BigDecimal totalSales = getTotalSales(orderList);
        salesReport.setNumberOfPaidOrders(numberOfPaidOrders);
        salesReport.setNumberOfUnPaidOrders(numberOfUnPaidOrders);
        salesReport.setCostOfIngredients(costOfIngredients);
        salesReport.setTotalSales(totalSales);
        salesReport.setTotalRevenue(totalSales.subtract(costOfIngredients));
        reportRepository.save(salesReport);
    }

    private void getAllOrders(long outletId){
        orderList = outletRepository.getAllById(outletId);
    }

    private void getAllIngredients(){
        ingredientList = (List<Ingredient>) ingredientRepository.findAll();
    }

    private int getNumberOfPaidOrders(List<Order> orderList){
        return (int) orderList.stream().filter(Order::isPayed).count();
    }

    private int getNumberOfUnPaidOrders(List<Order> orderList){
        return (int) orderList.stream().filter(order -> !order.isPayed()).count();
    }

    private int getNumberOfOrders(List<Order> orderList){
        return orderList.size();
    }

    private int getNumberOfCustomers(List<Order> orderList){
        return orderList.stream().mapToInt(Order::getNumberOfCustomers).reduce(Integer::sum).orElse(0);
    }

    private BigDecimal getCostOfIngredients(List<Ingredient> ingredientList){
        return ingredientList.stream().map(Ingredient::getTotalPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    private BigDecimal getTotalSales(List<Order> orderList){
        return orderList.stream().map(Order::getTotalCost).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }
}

