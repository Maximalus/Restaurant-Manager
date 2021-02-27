package com.maximalus.service.impl;

import com.maximalus.model.Ingredient;
import com.maximalus.repository.IngredientRepository;
import com.maximalus.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient save(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public Ingredient findById(Long id){
        return ingredientRepository.findById(id).orElseThrow();
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
