package com.maximalus.service.impl;

import com.maximalus.exception.RestaurantManagerException;
import com.maximalus.model.product.ingredient.IngredientGroup;
import com.maximalus.repository.IngredientGroupRepository;
import com.maximalus.service.IngredientGroupService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class IngredientGroupServiceImpl implements IngredientGroupService {
    private IngredientGroupRepository ingredientGroupRepository;

    public IngredientGroup save(IngredientGroup ingredientGroup){
        return ingredientGroupRepository.save(ingredientGroup);
    }

    public IngredientGroup findById(Long id){
        return ingredientGroupRepository.findById(id)
                .orElseThrow(() -> new RestaurantManagerException(String.format("Ingredient group with id $s does not exist", id)));
    }

    public IngredientGroup findByName(String name){
        return ingredientGroupRepository.findByName(name);
    }

    public List<IngredientGroup> findAll(){
        return (List<IngredientGroup>) ingredientGroupRepository.findAll();
    }

    public IngredientGroup update(IngredientGroup ingredientGroup){
        return ingredientGroupRepository.save(ingredientGroup);
    }

    public void deleteById(Long id){
        ingredientGroupRepository.deleteById(id);
    }
}
