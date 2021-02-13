package com.maximalus.service;

import com.maximalus.model.Role;
import com.maximalus.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }

    public List<Role> findAll(){
        return (List<Role>) roleRepository.findAll();
    }
}
