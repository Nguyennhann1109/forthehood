package com.forthehood.forthehood.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forthehood.forthehood.entity.Collection;

public interface CollectionRepository extends JpaRepository<Collection, Long> {

}