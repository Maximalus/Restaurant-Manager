package com.maximalus.service;

import com.maximalus.model.Ingredient;
import com.maximalus.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public Ingredient save(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public Ingredient findById(Long id){
        return ingredientRepository.getOne(id);
    }

    public List<Ingredient> findAll(){
        return (List<Ingredient>) ingredientRepository.findAll();
    }

    public Ingredient update(Ingredient ingredient){
        return ingredientRepository.save(ingredient);
    }

    public void delete(Long id){
        ingredientRepository.deleteById(id);
    }

}
