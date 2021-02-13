package com.maximalus.service;

import com.maximalus.model.IngredientGroup;
import com.maximalus.repository.IngredientGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientGroupService {
    @Autowired
    private IngredientGroupRepository ingredientGroupRepository;

    public IngredientGroup save(IngredientGroup ingredientGroup){
        return ingredientGroupRepository.save(ingredientGroup);
    }

    public IngredientGroup findById(Long id){
        return ingredientGroupRepository.findById(id).orElseThrow();
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
