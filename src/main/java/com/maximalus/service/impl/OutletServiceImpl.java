package com.maximalus.service.impl;

import com.maximalus.model.Outlet;
import com.maximalus.repository.OutletRepository;
import com.maximalus.service.OutletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OutletServiceImpl implements OutletService {
    @Autowired
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
}
