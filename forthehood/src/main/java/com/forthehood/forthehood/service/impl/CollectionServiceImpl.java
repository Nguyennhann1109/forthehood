package com.forthehood.forthehood.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.forthehood.forthehood.entity.Collection;
import com.forthehood.forthehood.repository.CollectionRepository;
import com.forthehood.forthehood.service.CollectionService;

@Service
public class CollectionServiceImpl implements CollectionService {

    private final CollectionRepository collectionRepository;

    public CollectionServiceImpl(CollectionRepository collectionRepository){
        this.collectionRepository = collectionRepository;
    }

    @Override
    public List<Collection> getAllCollections(){
        return collectionRepository.findAll();
    }

    @Override
    public Collection createCollection(Collection collection){
        return collectionRepository.save(collection);
    }

}