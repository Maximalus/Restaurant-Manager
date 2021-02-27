package com.maximalus.service;

import com.maximalus.model.Credential;

public interface CredentialService {
    void save(Credential credential);
    Credential findByUsername(String username);
}
