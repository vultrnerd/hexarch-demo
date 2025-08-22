package com.example.infrastructure.adapters.portsout.rest;

import com.example.shared.config.WeatherApiConfig;
import com.example.shared.dtos.WeatherForecastDTO;
import com.example.shared.ports.out.WeatherServiceApiPort;
import org.springframework.http.HttpStatusCode;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class OpenWeatherServiceApiClient implements WeatherServiceApiPort {
    private final WebClient webClient;
    private final String apiKey;
    private final String baseUrl;
    private final String units;

    public OpenWeatherServiceApiClient(WebClient.Builder webClientBuilder, WeatherApiConfig weatherApiConfig) {
        this.baseUrl = weatherApiConfig.getUrl();
        this.apiKey = weatherApiConfig.getKey();
        this.units = weatherApiConfig.getUnits();
        this.webClient = webClientBuilder.baseUrl(this.baseUrl).build();
    }

    @Override
    @Retryable(
        value = {RuntimeException.class},
        maxAttempts = 3,
        backoff = @Backoff(delay = 1000, maxDelay = 3000, multiplier = 2) // Retry configuration, could be externalized to a config class
    )
    public Mono<WeatherForecastDTO> getWeatherByCity(String cityName) {
        return this.webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("q", cityName)
                        .queryParam("appid", this.apiKey)
                        .queryParam("units", this.units)
                        .build())
                .retrieve()
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> Mono.error(new RuntimeException("Error fetching OpenWeather data")))
                .bodyToMono(WeatherForecastDTO.class);
    }
}