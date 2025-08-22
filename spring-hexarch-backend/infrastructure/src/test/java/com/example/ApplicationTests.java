package com.example;

import com.example.domain.WeatherForecast;
import com.example.infrastructure.adapters.portsin.rest.WeatherController;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private WeatherController weatherController;

    @Test
    public void contextLoads() {
        assertThat(weatherController).isNotNull();
    }

    @Test
    public void testWeatherEndpoint404() {
        // This is a simple test that assumes the weather API is accessible
        // In a real test, you would mock the external API
        ResponseEntity<WeatherForecast> response = restTemplate.getForEntity("/api/weather?city=Berlin", WeatherForecast.class);
        assertTrue(response.getStatusCode().isError());
        assertThat(response.getBody()).isNotNull();
        assertNull(response.getBody().getCityName());
    }
}