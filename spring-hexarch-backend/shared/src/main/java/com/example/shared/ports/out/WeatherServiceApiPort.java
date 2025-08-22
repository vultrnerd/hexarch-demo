package com.example.shared.ports.out;

import com.example.shared.dtos.WeatherForecastDTO;
import reactor.core.publisher.Mono;

public interface WeatherServiceApiPort {
    Mono<WeatherForecastDTO> getWeatherByCity(String cityName);
}