package com.maximalus.service.impl;

import com.maximalus.exception.NotFoundException;
import com.maximalus.exception.RestaurantManagerException;
import com.maximalus.model.storage.IngredientStorage;
import com.maximalus.repository.StorageRepository;
import com.maximalus.service.StorageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StorageServiceImpl implements StorageService {
    private final StorageRepository storageRepository;

    @Override
    public void save(IngredientStorage ingredientStorage) {
        storageRepository.save(ingredientStorage);
    }

    @Override
    public void update(IngredientStorage ingredientStorage) {
        storageRepository.save(ingredientStorage);
    }

    @Override
    public List<IngredientStorage> findAll() {
        return (List<IngredientStorage>) storageRepository.findAll();
    }

    @Override
    public IngredientStorage findById(Long id) {
        return storageRepository
                .findById(id)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Storage with id $s does not exist", id)));
    }

    @Override
    public void deleteById(Long id) {
        storageRepository.deleteById(id);
    }
}
