package com.forthehood.forthehood.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forthehood.forthehood.entity.Collection;
import com.forthehood.forthehood.service.CollectionService;

@RestController
@RequestMapping("/api/collections")
public class CollectionController {

    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService){
        this.collectionService = collectionService;
    }

    @GetMapping
    public List<Collection> getAllCollections(){
        return collectionService.getAllCollections();
    }

    @PostMapping
    public Collection createCollection(@RequestBody Collection collection){
        return collectionService.createCollection(collection);
    }

}