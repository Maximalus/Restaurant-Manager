package com.maximalus.repository;

import com.maximalus.model.Product;
import com.maximalus.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Transactional(readOnly = true)
//    @Query("select recipeList from Product product join fetch product.recipeList recipeList where product.nameOfProduct=:nameOfProduct")
    List<Recipe> getAllById(Long id);
}
