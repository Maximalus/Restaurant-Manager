package com.maximalus.service;

import com.maximalus.model.Credential;

public interface CredentialService {
    Credential save(Credential credential);
    Credential findByUsername(String username);
}
