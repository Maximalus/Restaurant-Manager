package com.maximalus.service.impl;

import com.maximalus.model.Role;
import com.maximalus.repository.RoleRepository;
import com.maximalus.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findByName(String name){
        return roleRepository.findByName(name);
    }

    public List<Role> findAll(){
        return (List<Role>) roleRepository.findAll();
    }
}
