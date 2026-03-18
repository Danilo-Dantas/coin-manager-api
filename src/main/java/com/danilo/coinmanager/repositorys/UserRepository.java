package com.danilo.coinmanager.repositorys;

import com.danilo.coinmanager.entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserDetails findByLogin(String login);
}
