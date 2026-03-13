package com.forthehood.forthehood.service;

import java.util.List;

import com.forthehood.forthehood.entity.Color;

public interface ColorService {

    List<Color> getAllColors();

    Color getColorById(Long id);

    Color createColor(Color color);

    Color updateColor(Long id, Color color);

    void deleteColor(Long id);

}