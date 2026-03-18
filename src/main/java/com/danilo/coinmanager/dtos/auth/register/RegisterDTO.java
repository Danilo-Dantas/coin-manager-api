package com.danilo.coinmanager.dtos.auth.register;

import com.danilo.coinmanager.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) { }
