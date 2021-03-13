package com.maximalus.service;

import com.maximalus.model.storage.Storage;

import java.util.List;

public interface StorageService {
    void save(Storage storage);
    void update(Storage storage);
    List<Storage> findAll();
    Storage findById(Long id);
    void deleteById(Long id);
}
