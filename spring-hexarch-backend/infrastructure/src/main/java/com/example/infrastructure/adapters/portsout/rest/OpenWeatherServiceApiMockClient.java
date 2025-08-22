package com.example.infrastructure.adapters.portsout.rest;

import com.example.shared.dtos.WeatherForecastDTO;
import com.example.shared.ports.out.WeatherServiceApiPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

public class OpenWeatherServiceApiMockClient implements WeatherServiceApiPort {

    @Override
    public Mono<WeatherForecastDTO> getWeatherByCity(String cityName) {
        return Mono.just(WeatherForecastDTO.MUNICH());
    }
}