package com.pedro.demo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpj) throws Exception {
        httpj.csrf(csrf -> csrf.disable());

        httpj.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return httpj.build();
    }
}

