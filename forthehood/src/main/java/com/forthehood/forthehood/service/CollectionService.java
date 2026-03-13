package com.forthehood.forthehood.service;

import java.util.List;

import com.forthehood.forthehood.entity.Collection;

public interface CollectionService {

    List<Collection> getAllCollections();

    Collection createCollection(Collection collection);

}