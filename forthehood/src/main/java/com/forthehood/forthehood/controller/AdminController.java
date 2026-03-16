package com.forthehood.forthehood.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forthehood.forthehood.entity.User;
import com.forthehood.forthehood.service.AuthService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AuthService authService;

    public AdminController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/create-employee")
    public User createEmployee(@RequestBody User user){
        return authService.createEmployee(user);
    }

}