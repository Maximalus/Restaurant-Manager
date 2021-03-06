package com.maximalus.service.impl;

import com.maximalus.model.Credential;
import com.maximalus.model.User;
import com.maximalus.repository.UserRepository;
import com.maximalus.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public void update(User user){
        user.setChangingDate(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public void save(User user) {
        user.setCreationDate(LocalDateTime.now());
        user.setChangingDate(LocalDateTime.now());
        userRepository.save(user);
    }

    @Override
    public User findByCredential(Credential credential) {
        return userRepository.findByCredential(credential);
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
