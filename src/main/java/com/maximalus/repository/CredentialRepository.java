package com.maximalus.repository;

import com.maximalus.model.Credential;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends CrudRepository<Credential, Long> {
    Optional<Credential> findByUsername(String username);
}
