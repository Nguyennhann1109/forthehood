package com.forthehood.forthehood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forthehood.forthehood.entity.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {

}