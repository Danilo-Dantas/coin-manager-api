package com.danilo.coinmanager.service;

import com.danilo.coinmanager.dto.user.UserRegisterRequest;
import com.danilo.coinmanager.entity.UserEntity;
import com.danilo.coinmanager.mapper.UserMapper;
import com.danilo.coinmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserRegisterRequest request) throws Exception {
        try{
            UserEntity entity = UserMapper.fromUserRequestToEntity(request);
            userRepository.save(entity);
        } catch (Exception e) {
            throw new Exception("Error during user register process.", e.getCause());
        }

    }


}
