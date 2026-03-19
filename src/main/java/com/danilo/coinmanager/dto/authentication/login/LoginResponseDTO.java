package com.danilo.coinmanager.dto.authentication.login;

public record LoginResponseDTO(String accessToken, String tokenType, Integer expiresIn) { }