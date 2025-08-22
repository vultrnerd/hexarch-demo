package com.example.application.usecases;

import com.example.application.mappers.WeatherForecastMapper;
import com.example.shared.annotations.UseCase;
import com.example.shared.dtos.WeatherForecastDTO;
import com.example.shared.ports.in.GetWeatherByCityPort;
import com.example.shared.ports.out.WeatherServiceApiPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@UseCase
@Service
public class GetWeatherByCityUseCase implements GetWeatherByCityPort {

    private final WeatherServiceApiPort weatherServiceApiPort; // outbound port
    private final WeatherForecastMapper weatherForecastMapper;

    @Autowired
    public GetWeatherByCityUseCase(WeatherServiceApiPort weatherServiceApiPort, WeatherForecastMapper weatherForecastMapper) {
        this.weatherServiceApiPort = weatherServiceApiPort;
        this.weatherForecastMapper = weatherForecastMapper;
    }

    @Override
    public ResponseEntity<WeatherForecastDTO> getWeatherByCity(String cityName) {
        var weather = this.weatherServiceApiPort.getWeatherByCity(cityName).block();
        if (weather == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(weather);
    }

}