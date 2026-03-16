package com.danilo.coinmanager.dto.auth;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterResponse {

    private String name;
    private String email;

}