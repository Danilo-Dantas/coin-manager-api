package com.danilo.coinmanager.repository;

import com.danilo.coinmanager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserDetails findByEmail(String email);
}
