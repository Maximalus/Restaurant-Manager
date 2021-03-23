package com.maximalus.service;

import com.maximalus.model.product.ingredient.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IngredientService {
    Ingredient save(Ingredient ingredient);
    Ingredient findById(Long id);
    List<Ingredient> findAll();
    Page<Ingredient> findAll(Pageable pageable);
    Ingredient update(Ingredient ingredient);
    void deleteById(Long id);
}
