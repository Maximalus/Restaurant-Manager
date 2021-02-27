package com.maximalus.service.impl;

import com.maximalus.model.Outlet;
import com.maximalus.repository.OutletRepository;
import com.maximalus.service.OutletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutletServiceImpl implements OutletService {
    @Autowired
    private OutletRepository outletRepository;

    public List<Outlet> findAll(){
        return (List<Outlet>) outletRepository.findAll();
    }

    public Outlet findByName(String name){
        return outletRepository.findByName(name);
    }
}
