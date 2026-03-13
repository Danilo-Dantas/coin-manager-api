package com.danilo.coinmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/actuator")
public class ActuatorController {

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {

        return ResponseEntity.ok("UP");
    }
}
