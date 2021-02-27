package com.maximalus.service;

import com.maximalus.model.Ingredient;

import java.util.List;

public interface IngredientService {
    Ingredient save(Ingredient ingredient);
    Ingredient findById(Long id);
    List<Ingredient> findAll();
    Ingredient update(Ingredient ingredient);
    void deleteById(Long id);
}
