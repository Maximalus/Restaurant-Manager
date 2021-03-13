package com.maximalus.service.impl;

import com.maximalus.exception.RestaurantManagerException;
import com.maximalus.model.storage.Storage;
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
    public void save(Storage storage) {
        storageRepository.save(storage);
    }

    @Override
    public void update(Storage storage) {
        storageRepository.save(storage);
    }

    @Override
    public List<Storage> findAll() {
        return (List<Storage>) storageRepository.findAll();
    }

    @Override
    public Storage findById(Long id) {
        return storageRepository
                .findById(id)
                .orElseThrow(() ->
                        new RestaurantManagerException(String.format("Storage with id $s does not exist", id)));
    }

    @Override
    public void deleteById(Long id) {
        storageRepository.deleteById(id);
    }
}
