package com.maximalus.service.impl;

import com.maximalus.model.Credential;
import com.maximalus.model.Role;
import com.maximalus.repository.CredentialRepository;
import com.maximalus.service.CredentialService;
import com.maximalus.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CredentialServiceImpl implements CredentialService {
    @Autowired
    private CredentialRepository credentialRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;

    @Override
    public void save(Credential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
        credential.setRole(getDefaultRole());
        credentialRepository.save(credential);
    }

    public Credential findByUsername(String username){
        return credentialRepository.findByUsername(username).orElseThrow();
    }

    private Role getDefaultRole(){
        return roleService.findByName("DEFAULT");
    }
}
