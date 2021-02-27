package com.maximalus.service;

import com.maximalus.model.Credential;
import com.maximalus.model.User;

import java.util.List;

public interface UserService {
    void update(User user);
    void save(User user);
    User findByCredential(Credential credential);
    List<User> findAll();
    User findById(Long id);
    void deleteById(Long id);
}
