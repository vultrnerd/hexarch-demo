package com.example.shared.ports.in;

import com.example.shared.dtos.LoginRequestDTO;

public interface LoginUserPort {
    void login(LoginRequestDTO dto);
}
