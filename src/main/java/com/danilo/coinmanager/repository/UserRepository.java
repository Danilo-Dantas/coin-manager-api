package com.danilo.coinmanager.repository;

import com.danilo.coinmanager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
