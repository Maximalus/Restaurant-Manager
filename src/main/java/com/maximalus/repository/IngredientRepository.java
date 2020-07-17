package com.maximalus.repository;

import com.maximalus.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Ingredient findByNameOfIngredient(String name);
}
