package com.maximalus.service;

import com.maximalus.model.*;
import com.maximalus.model.Order;
import com.maximalus.repository.IngredientRepository;
import com.maximalus.repository.OutletRepository;
import com.maximalus.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReportService {
    private final ReportRepository reportRepository;
    private final OutletRepository outletRepository;
    private final IngredientRepository ingredientRepository;

    private List<Order> orderList = new ArrayList<>();
    private List<Ingredient> ingredientList = new ArrayList<>();

    @Autowired
    public ReportService(ReportRepository reportRepository, OutletRepository outletRepository, IngredientRepository ingredientRepository) {
        this.reportRepository = reportRepository;
        this.outletRepository = outletRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public void save(GeneralReport generalReport, long outletId){
        getAllOrders(outletId);
        int numberOfCustomers = getNumberOfCustomers(orderList);
        int numberOfOrders = getNumberOfOrders(orderList);
        int numberOfUnPaidOrders = getNumberOfUnPaidOrders(orderList);
        generalReport.setOutlet(outletRepository.getOne(outletId));
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
        double costOfIngredients = getCostOfIngredients(ingredientList);
        double totalSales = getTotalSales(orderList);
        salesReport.setNumberOfPaidOrders(numberOfPaidOrders);
        salesReport.setNumberOfUnPaidOrders(numberOfUnPaidOrders);
        salesReport.setCostOfIngredients(costOfIngredients);
        salesReport.setTotalSales(totalSales);
        salesReport.setTotalRevenue(totalSales-costOfIngredients);
        reportRepository.save(salesReport);
    }

    private void getAllOrders(long outletId){
        orderList = outletRepository.getAllById(outletId);
    }

    private void getAllIngredients(){
        ingredientList = ingredientRepository.findAll();
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

    private double getCostOfIngredients(List<Ingredient> ingredientList){
        return ingredientList.stream().mapToDouble(Ingredient::getTotalPrice).reduce(Double::sum).orElse(0.0);
    }

    private double getTotalSales(List<Order> orderList){
        return orderList.stream().mapToDouble(Order::getTotalCost).reduce(Double::sum).orElse(0.0);
    }
}

