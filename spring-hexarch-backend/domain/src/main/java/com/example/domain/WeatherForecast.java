package com.example.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
public class WeatherForecast {
    private String cityName;
    private LocalDateTime dateTime;
    private List<WeatherData> weatherDataList;
}