package com.maximalus.service.impl;

import com.maximalus.model.Credential;
import com.maximalus.repository.CredentialRepository;
import com.maximalus.service.CredentialService;
import com.maximalus.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@AllArgsConstructor
public class CredentialServiceImpl implements CredentialService {
    private final CredentialRepository credentialRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Credential save(Credential credential) {
        String password = passwordEncoder.encode(credential.getPassword());
        credential.setCreationDate(LocalDateTime.now());
        credential.setChangingDate(LocalDateTime.now());
        credential.setPassword(password);
        return credentialRepository.save(credential);
    }

    @Override
    public Credential findByUsername(String username){
        return credentialRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with username $s does not exist", username)));
    }
}
