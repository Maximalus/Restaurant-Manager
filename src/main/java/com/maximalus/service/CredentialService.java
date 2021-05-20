package com.maximalus.service;

import com.maximalus.model.Credential;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CredentialService {
    Credential save(Credential credential);
    Credential findByUsername(String username);
    Credential findById(Long id);
    List<Credential> findAll();
    Credential update(Credential credential);
    void deleteById(Long id);
    Page<Credential> findAll(Pageable pageable);
}
