package com.forthehood.forthehood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forthehood.forthehood.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}