package com.maximalus.service;

import com.maximalus.model.Order;
import com.maximalus.model.Outlet;

import java.util.List;

public interface OutletService {
    List<Outlet> findAll();
    Outlet findByName(String name);
    List<String> getListOfOutletNames();
    Outlet findById(Long id);
    List<Order> getAllOrdersByOutletId(Long id);
}
