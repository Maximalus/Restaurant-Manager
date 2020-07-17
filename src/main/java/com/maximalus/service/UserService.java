package com.maximalus.service;

import com.maximalus.model.User;
import com.maximalus.model.UserRole;
import com.maximalus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setPassword(passwordEncoder.encode(user.getPasswordConfirm()));
        user.setUserRole(UserRole.MANAGER);
        userRepository.save(user);
    }

    public void update(User user){
        userRepository.save(user);
    }

    public User findByEmail(String username){
        return userRepository.findByEmail(username);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getOne(Long id){
        return userRepository.getOne(id);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
