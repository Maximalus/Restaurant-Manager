package com.maximalus.service.impl;

import com.maximalus.model.IngredientGroup;
import com.maximalus.repository.IngredientGroupRepository;
import com.maximalus.service.IngredientGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IngredientGroupServiceImpl implements IngredientGroupService {
    @Autowired
    private IngredientGroupRepository ingredientGroupRepository;

    public IngredientGroup save(IngredientGroup ingredientGroup){
        return ingredientGroupRepository.save(ingredientGroup);
    }

    public IngredientGroup findById(Long id){
        return ingredientGroupRepository.findById(id).orElseThrow();
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
