package com.maximalus.service;

import com.maximalus.model.User;
import com.maximalus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPassword(passwordEncoder.encode(user.getPasswordConfirm()));
        userRepository.save(user);
    }

    public void update(User user){
        userRepository.save(user);
    }

    public User findByEmail(String username){
        return userRepository.findByEmail(username).orElseThrow();
    }

    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow();
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
