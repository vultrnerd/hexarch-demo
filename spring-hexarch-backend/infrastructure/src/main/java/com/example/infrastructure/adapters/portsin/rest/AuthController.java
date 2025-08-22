package com.example.infrastructure.adapters.portsin.rest;

import com.example.shared.dtos.LoginRequestDTO;
import com.example.shared.ports.in.LoginUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final LoginUserPort loginUserPort; // inbound port

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto) {
        loginUserPort.login(dto);
        return ResponseEntity.ok("logged in");
    }

}

