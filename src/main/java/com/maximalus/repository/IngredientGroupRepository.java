package com.maximalus.repository;

import com.maximalus.model.IngredientGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientGroupRepository extends CrudRepository<IngredientGroup, Long> {
}
