package com.maximalus.service.impl;

import com.maximalus.model.Credential;
import com.maximalus.model.Role;
import com.maximalus.repository.CredentialRepository;
import com.maximalus.service.CredentialService;
import com.maximalus.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CredentialServiceImpl implements CredentialService {
    private final CredentialRepository credentialRepository;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void deleteById(Long id) {
        Credential credential = findById(id);
        credential.setDeleted(true);
        credential.setChangingDate(LocalDateTime.now());
        update(credential);
    }

    @Override
    public Page<Credential> findAll(Pageable pageable) {
        return credentialRepository.findAll(pageable);
    }

    @Override
    public Credential update(Credential credential) {
        credential.setChangingDate(LocalDateTime.now());
        return credentialRepository.save(credential);
    }

    @Override
    public Credential save(Credential credential) {
        String password = passwordEncoder.encode(credential.getPassword());
        Role role = roleService.findByName("DEFAULT");
        credential.setRole(role);
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

    @Override
    public Credential findById(Long id) {
        return credentialRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with id $d does not exist", id)));
    }

    @Override
    public List<Credential> findAll() {
        return (List<Credential>) credentialRepository.findAll();
    }
}
