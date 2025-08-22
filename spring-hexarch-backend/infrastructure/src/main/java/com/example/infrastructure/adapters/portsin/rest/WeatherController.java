package com.example.infrastructure.adapters.portsin.rest;

import com.example.shared.dtos.WeatherForecastDTO;
import com.example.shared.ports.in.GetWeatherByCityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final GetWeatherByCityPort getWeatherByCityPort; // inbound port

    @GetMapping("/{city}")
    public ResponseEntity<WeatherForecastDTO> getWeatherByCity(@PathVariable String city) {
        return this.getWeatherByCityPort.getWeatherByCity(city);
    }

}