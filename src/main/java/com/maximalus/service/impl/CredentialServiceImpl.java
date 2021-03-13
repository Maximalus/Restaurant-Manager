package com.maximalus.service.impl;

import com.maximalus.exception.RestaurantManagerException;
import com.maximalus.model.Credential;
import com.maximalus.repository.CredentialRepository;
import com.maximalus.service.CredentialService;
import com.maximalus.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@AllArgsConstructor
public class CredentialServiceImpl implements CredentialService {
    private CredentialRepository credentialRepository;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    @Override
    public void save(Credential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        credential.setCreationDate(LocalDateTime.now());
        credential.setChangingDate(LocalDateTime.now());
        credentialRepository.save(credential);
    }

    @Override
    public Credential findByUsername(String username){
        return credentialRepository.findByUsername(username)
                .orElseThrow(() -> new RestaurantManagerException(String.format("User with username $s does not exist", username)));
    }
}
