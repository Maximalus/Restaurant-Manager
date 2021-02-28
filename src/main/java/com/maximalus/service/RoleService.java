package com.maximalus.service;

import com.maximalus.model.Role;

import java.util.List;

public interface RoleService {
    Role findByName(String name);
    List<String> getListOfRoleNames();
    List<Role> findAll();
}
