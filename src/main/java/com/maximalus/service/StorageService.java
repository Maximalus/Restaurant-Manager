package com.maximalus.service;

import com.maximalus.model.storage.IngredientStorage;

import java.util.List;

public interface StorageService {
    void save(IngredientStorage ingredientStorage);
    void update(IngredientStorage ingredientStorage);
    List<IngredientStorage> findAll();
    IngredientStorage findById(Long id);
    void deleteById(Long id);
}
