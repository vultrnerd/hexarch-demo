package com.example.shared.ports.in;

import com.example.shared.dtos.WeatherForecastDTO;
import org.springframework.http.ResponseEntity;

public interface GetWeatherByCityPort {
    ResponseEntity<WeatherForecastDTO> getWeatherByCity(String cityName);
}