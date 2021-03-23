package com.maximalus.repository;

import com.maximalus.model.product.ingredient.Ingredient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long>, PagingAndSortingRepository<Ingredient, Long> {
    Page<Ingredient> findAll(Pageable pageable);
}
