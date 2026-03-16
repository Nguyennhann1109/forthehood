package com.forthehood.forthehood.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                // AUTH API
                .requestMatchers("/api/auth/**").permitAll()

                // ADMIN API
                .requestMatchers("/api/admin/**").permitAll()

                // PRODUCT API
                .requestMatchers("/api/products/**").permitAll()

                // các API khác
                .anyRequest().permitAll()
            )
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable());

        return http.build();
    }
}