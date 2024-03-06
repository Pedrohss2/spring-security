package com.pedro.demo.dto;

import com.pedro.demo.entities.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
