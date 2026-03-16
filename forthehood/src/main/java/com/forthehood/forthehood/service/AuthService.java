package com.forthehood.forthehood.service;

import com.forthehood.forthehood.entity.User;

public interface AuthService {

    User registerCustomer(User user);

    String login(String email, String password);

    User createEmployee(User user);

}