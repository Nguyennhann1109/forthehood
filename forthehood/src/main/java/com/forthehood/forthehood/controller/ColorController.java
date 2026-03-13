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

import com.forthehood.forthehood.entity.Color;
import com.forthehood.forthehood.service.ColorService;

@RestController
@RequestMapping("/api/colors")
public class ColorController {

    private final ColorService colorService;

    public ColorController(ColorService colorService){
        this.colorService = colorService;
    }

    @GetMapping
    public List<Color> getAllColors(){
        return colorService.getAllColors();
    }

    @GetMapping("/{id}")
    public Color getColorById(@PathVariable Long id){
        return colorService.getColorById(id);
    }

    @PostMapping
    public Color createColor(@RequestBody Color color){
        return colorService.createColor(color);
    }

    @PutMapping("/{id}")
    public Color updateColor(@PathVariable Long id,
                             @RequestBody Color color){
        return colorService.updateColor(id, color);
    }

    @DeleteMapping("/{id}")
    public void deleteColor(@PathVariable Long id){
        colorService.deleteColor(id);
    }

}