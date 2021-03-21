package com.maximalus.service.impl;

import com.maximalus.exception.RestaurantManagerException;
import com.maximalus.model.product.ingredient.Ingredient;
import com.maximalus.repository.IngredientRepository;
import com.maximalus.service.IngredientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public Ingredient save(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public Ingredient findById(Long id){
        return ingredientRepository
                .findById(id)
                .orElseThrow(() -> new RestaurantManagerException("Ingredient with id " + id + " does not exists"));
    }

    public List<Ingredient> findAll(){
        return (List<Ingredient>) ingredientRepository.findAll();
    }

    public Ingredient update(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public void deleteById(Long id){
        ingredientRepository.deleteById(id);
    }

}
