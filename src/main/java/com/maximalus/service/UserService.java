package com.maximalus.service;

import com.maximalus.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void update(User user);
    User findByEmail(String username);
    List<User> findAll();
    User findById(Long id);
    void deleteById(Long id);
}
