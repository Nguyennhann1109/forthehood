package com.forthehood.forthehood.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forthehood.forthehood.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);

}