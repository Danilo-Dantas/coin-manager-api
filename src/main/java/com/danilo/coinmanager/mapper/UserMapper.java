package com.danilo.coinmanager.mapper;

import com.danilo.coinmanager.dto.user.UserRegisterRequest;
import com.danilo.coinmanager.entity.UserEntity;

import java.util.Date;

public class UserMapper {

    public static UserEntity fromUserRequestToEntity(UserRegisterRequest request) {

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
}
