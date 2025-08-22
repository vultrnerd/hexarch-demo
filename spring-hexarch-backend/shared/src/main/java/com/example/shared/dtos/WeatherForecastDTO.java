package com.example.shared.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
public class WeatherForecastDTO {
    private final String city;
    private final List<WeatherDataDTO> forecast;
    private final LocalDateTime lastUpdated;

    public static WeatherForecastDTO MUNICH() {
        return new WeatherForecastDTO(WeatherDataDTO.MUNICH().getCity(),
                List.of(WeatherDataDTO.MUNICH()),
                WeatherDataDTO.MUNICH().getTimestamp());
    }
}