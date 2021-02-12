package com.maximalus.security;

import com.maximalus.model.User;
import com.maximalus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service(value = "customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = Optional.ofNullable(userRepository.findByEmail(username)).orElse(null);
        if(user!=null){
            return new CustomUserDetails(user, Collections.singletonList(user.getRole().getName()));
        }
        throw new UsernameNotFoundException("No user present with username:" + username);
    }
}
