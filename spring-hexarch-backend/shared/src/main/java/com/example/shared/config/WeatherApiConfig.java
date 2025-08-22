package com.example.shared.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "weather.api")
public class WeatherApiConfig {
    private String url = "https://api.openweathermap.org/data/2.5/weather"; // Default URL
    private String key;
    private String units = "metric"; // Default to metric units
}
