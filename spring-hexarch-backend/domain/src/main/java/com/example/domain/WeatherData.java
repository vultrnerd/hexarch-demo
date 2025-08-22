package com.example.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class WeatherData {
    private String city;
    private String description;
    private double temperature;
    private double humidity;
    private double windSpeed;
}