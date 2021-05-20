package com.maximalus.repository;

import com.maximalus.model.Credential;
import com.maximalus.model.product.ingredient.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialRepository extends CrudRepository<Credential, Long>, PagingAndSortingRepository<Credential, Long> {
    Optional<Credential> findByUsername(String username);
    Page<Credential> findAll(Pageable pageable);
}
