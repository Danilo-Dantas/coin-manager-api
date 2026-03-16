package com.danilo.coinmanager.mapper;

import com.danilo.coinmanager.dto.auth.RegisterRequest;
import com.danilo.coinmanager.dto.auth.RegisterResponse;
import com.danilo.coinmanager.entity.UserEntity;

import java.util.Date;

public class UserMapper {

    public static UserEntity requestToEntity(RegisterRequest request) {

        UserEntity userEntity = UserEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .creationDate(new Date())
                .createdBy("admin")
                .updatedDate(new Date())
                .updatedBy("admin")
                .build();

        return userEntity;
    }

    public static RegisterResponse entityToResponse(UserEntity entity) {

        RegisterResponse response = RegisterResponse.builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .build();

        return response;
    }
}
