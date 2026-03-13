package com.forthehood.forthehood.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forthehood.forthehood.entity.Size;
import com.forthehood.forthehood.service.SizeService;

@RestController
@RequestMapping("/api/sizes")
public class SizeController {

    private final SizeService sizeService;

    public SizeController(SizeService sizeService){
        this.sizeService = sizeService;
    }

    @GetMapping
    public List<Size> getAllSizes(){
        return sizeService.getAllSizes();
    }

    @GetMapping("/{id}")
    public Size getSizeById(@PathVariable Long id){
        return sizeService.getSizeById(id);
    }

    @PostMapping
    public Size createSize(@RequestBody Size size){
        return sizeService.createSize(size);
    }

    @PutMapping("/{id}")
    public Size updateSize(@PathVariable Long id,
                           @RequestBody Size size){
        return sizeService.updateSize(id, size);
    }

    @DeleteMapping("/{id}")
    public void deleteSize(@PathVariable Long id){
        sizeService.deleteSize(id);
    }

}