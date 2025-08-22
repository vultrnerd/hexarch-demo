package com.example.shared.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class WeatherDataDTO {
    private final String city;
    private final double temperature;
    private final String description;
    private final double humidity;
    private final double windSpeed;
    private final LocalDateTime timestamp;

    public static WeatherDataDTO MUNICH() {
        return new WeatherDataDTO("Munich", 25.00, "Munich", 60.00, 40.00, LocalDateTime.now());
    }
}