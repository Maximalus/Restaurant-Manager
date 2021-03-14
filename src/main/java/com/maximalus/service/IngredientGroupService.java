package com.maximalus.service;

import com.maximalus.model.product.ingredient.IngredientGroup;

import java.util.List;

public interface IngredientGroupService {
    IngredientGroup findById(Long id);
    IngredientGroup findByName(String name);
    List<IngredientGroup> findAll();
    IngredientGroup update(IngredientGroup ingredientGroup);
    void deleteById(Long id);
}
