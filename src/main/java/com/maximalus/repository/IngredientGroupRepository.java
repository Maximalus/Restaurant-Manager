package com.maximalus.repository;

import com.maximalus.model.IngredientGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientGroupRepository extends JpaRepository<IngredientGroup, Long> {
}
