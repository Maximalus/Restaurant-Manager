package com.maximalus.service.impl;

import com.maximalus.model.Role;
import com.maximalus.repository.RoleRepository;
import com.maximalus.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name){
        return roleRepository.findByName(name);
    }

    @Override
    public List<Role> findAll(){
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public List<String> getListOfRoleNames(){
        return findAll()
                .stream()
                .filter(role -> !role.getName().equals("ADMINISTRATOR"))
                .filter(role -> !role.getName().equals("GENERAL_MANAGER"))
                .map(Role::getName).collect(Collectors.toList());
    }
}
