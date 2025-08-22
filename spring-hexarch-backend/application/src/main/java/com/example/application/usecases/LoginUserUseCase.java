package com.example.application.usecases;

import com.example.shared.annotations.UseCase;
import com.example.shared.dtos.LoginRequestDTO;
import com.example.shared.ports.in.LoginUserPort;
import org.springframework.stereotype.Service;

@UseCase
@Service
public class LoginUserUseCase implements LoginUserPort {

    @Override
    public void login(LoginRequestDTO dto) {
        System.out.println(dto.username() + " + logged in!");
    }

}