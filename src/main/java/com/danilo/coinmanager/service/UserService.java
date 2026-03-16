package com.danilo.coinmanager.service;

import com.danilo.coinmanager.dto.auth.RegisterRequest;
import com.danilo.coinmanager.dto.auth.RegisterResponse;
import com.danilo.coinmanager.entity.UserEntity;
import com.danilo.coinmanager.mapper.UserMapper;
import com.danilo.coinmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public RegisterResponse saveUser(RegisterRequest request) throws Exception {
        try{
            request.setPassword(passwordToBcrypt(request.getPassword()));
            UserEntity entity = UserMapper.requestToEntity(request);
            userRepository.save(entity);
            RegisterResponse response = UserMapper.entityToResponse(entity);

            return response;
        } catch (Exception e) {
            throw new Exception("Error during user register process.", e.getCause());
        }
    }

    private String passwordToBcrypt(String password) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        return bcrypt.encode(password);
    }


}
