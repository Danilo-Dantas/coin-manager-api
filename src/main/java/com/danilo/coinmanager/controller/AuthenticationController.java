package com.danilo.coinmanager.controller;

import com.danilo.coinmanager.dto.authentication.login.LoginRequestDTO;
import com.danilo.coinmanager.dto.authentication.login.LoginResponseDTO;
import com.danilo.coinmanager.dto.authentication.register.RegisterRequestDTO;
import com.danilo.coinmanager.entity.UserEntity;
import com.danilo.coinmanager.enums.UserRole;
import com.danilo.coinmanager.infra.TokenService;
import com.danilo.coinmanager.repositorys.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterRequestDTO dto) {
        if (userRepository.findByEmail(dto.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = passwordEncoder.encode(dto.password());
        UserEntity entity = new UserEntity(dto.name(), dto.email(), encryptedPassword, UserRole.USER);
        userRepository.save(entity);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginRequestDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserEntity) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token.accessToken(), token.tokenType(), token.expiresIn()));
    }


}
