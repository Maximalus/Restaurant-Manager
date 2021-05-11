package com.maximalus.service.impl;

import com.maximalus.exception.NotFoundException;
import com.maximalus.exception.RestaurantManagerException;
import com.maximalus.model.product.ingredient.IngredientGroup;
import com.maximalus.repository.IngredientGroupRepository;
import com.maximalus.service.IngredientGroupService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class IngredientGroupServiceImpl implements IngredientGroupService {
    private IngredientGroupRepository ingredientGroupRepository;

    @Override
    public IngredientGroup save(IngredientGroup ingredientGroup){
        return ingredientGroupRepository.save(ingredientGroup);
    }

    @Override
    public IngredientGroup findById(Long id){
        return ingredientGroupRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Ingredient group with id $s does not exist", id)));
    }

    @Override
    public IngredientGroup findByName(String name){
        return ingredientGroupRepository.findByName(name);
    }

    @Override
    public List<IngredientGroup> findAll(){
        return (List<IngredientGroup>) ingredientGroupRepository.findAll();
    }

    @Override
    public IngredientGroup update(IngredientGroup ingredientGroup){
        return ingredientGroupRepository.save(ingredientGroup);
    }

    @Override
    public void deleteById(Long id){
        IngredientGroup ingredientGroup = findById(id);
        ingredientGroup.setDeleted(true);
        ingredientGroup.setChangingDate(LocalDateTime.now());
        update(ingredientGroup);
    }
}
