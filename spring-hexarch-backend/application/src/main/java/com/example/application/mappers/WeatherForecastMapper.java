package com.example.application.mappers;

import com.example.domain.WeatherForecast;
import com.example.shared.config.GlobalMapperConfig;
import com.example.shared.dtos.WeatherForecastDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = GlobalMapperConfig.class)
public interface WeatherForecastMapper {

    @Mapping(target = "city", source = "cityName")
    @Mapping(target = "forecast", source = "weatherDataList")
    @Mapping(target = "lastUpdated", source = "dateTime")
    WeatherForecastDTO toDTO(WeatherForecast weatherForecast);

    @Mapping(target = "cityName", source = "city")
    @Mapping(target = "weatherDataList", source = "forecast")
    @Mapping(target = "dateTime", source = "lastUpdated")
    WeatherForecast toEntity(WeatherForecastDTO weatherForecastDTO);

}