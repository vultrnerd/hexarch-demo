package com.example.config;

import com.example.infrastructure.adapters.portsout.rest.OpenWeatherServiceApiMockClient;
import com.example.shared.ports.out.WeatherServiceApiPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherConfig {

    @Bean
    public WeatherServiceApiPort weatherServiceApiPort() {
        return new OpenWeatherServiceApiMockClient();
    }

}