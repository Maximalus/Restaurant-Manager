package com.maximalus.service.impl;

import com.maximalus.model.Credential;
import com.maximalus.repository.CredentialRepository;
import com.maximalus.service.CredentialService;
import com.maximalus.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CredentialServiceImpl implements CredentialService, UserDetailsService {
    private final CredentialRepository credentialRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void save(Credential credential) {
        String password = passwordEncoder.encode(credential.getPassword());
        credential.setPassword(password);
        credential.setCreationDate(LocalDateTime.now());
        credential.setChangingDate(LocalDateTime.now());
        credentialRepository.save(credential);
    }

    @Override
    public Credential findByUsername(String username){
        return credentialRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with username $s does not exist", username)));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credential credential = findByUsername(username);
        if(Objects.isNull(credential)){
            throw new UsernameNotFoundException(String.format("{User %s is not found}", username));
        }
        return new org.springframework.security.core.userdetails.User
                (credential.getUsername(), credential.getPassword(), true,
                        true, true, true,
                        credential.getRole().getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getName())).collect(Collectors.toSet()));
    }
}
