package com.maximalus.repository;

import com.maximalus.model.storage.IngredientStorage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends CrudRepository<IngredientStorage, Long> {
}
