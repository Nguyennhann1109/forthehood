package com.forthehood.forthehood.service;

import java.util.List;

import com.forthehood.forthehood.entity.Category;

public interface CategoryService {

    List<Category> getAllCategories();

    Category createCategory(Category category);

}