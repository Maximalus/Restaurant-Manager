package com.maximalus.repository;

import com.maximalus.model.Product;
import com.maximalus.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Transactional(readOnly = true)
//    @Query("select recipeList from Product product join fetch product.recipeList recipeList where product.nameOfProduct=:nameOfProduct")
    List<Recipe> getAllById(Long id);
}
