package com.forthehood.forthehood.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.forthehood.forthehood.entity.Color;
import com.forthehood.forthehood.repository.ColorRepository;
import com.forthehood.forthehood.service.ColorService;

@Service
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;

    public ColorServiceImpl(ColorRepository colorRepository){
        this.colorRepository = colorRepository;
    }

    @Override
    public List<Color> getAllColors(){
        return colorRepository.findAll();
    }

    @Override
    public Color getColorById(Long id){
        return colorRepository.findById(id).orElse(null);
    }

    @Override
    public Color createColor(Color color){
        return colorRepository.save(color);
    }

    @Override
    public Color updateColor(Long id, Color color){
        color.setId(id);
        return colorRepository.save(color);
    }

    @Override
    public void deleteColor(Long id){
        colorRepository.deleteById(id);
    }

}