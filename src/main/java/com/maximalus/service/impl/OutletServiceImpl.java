package com.maximalus.service.impl;

import com.maximalus.exception.NotFoundException;
import com.maximalus.exception.RestaurantManagerException;
import com.maximalus.model.Order;
import com.maximalus.model.Outlet;
import com.maximalus.repository.OutletRepository;
import com.maximalus.service.OutletService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class OutletServiceImpl implements OutletService {
    private OutletRepository outletRepository;

    @Override
    public List<Outlet> findAll(){
        return (List<Outlet>) outletRepository.findAll();
    }

    @Override
    public Outlet findByName(String name){
        return outletRepository.findByName(name);
    }

    @Override
    public List<String> getListOfOutletNames(){
        return findAll()
                .stream().map(Outlet::getName).collect(Collectors.toList());
    }

    @Override
    public Outlet findById(Long id) {
        return outletRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Outlet with id %d does not exist", id)));
    }

    @Override
    public List<Order> getAllOrdersByOutletId(Long id) {
        return findById(id).getOrderList();
    }
}
