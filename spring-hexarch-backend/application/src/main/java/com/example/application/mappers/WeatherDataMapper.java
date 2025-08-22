package com.example.application.mappers;

import com.example.domain.WeatherData;
import com.example.shared.config.GlobalMapperConfig;
import com.example.shared.dtos.WeatherDataDTO;
import org.mapstruct.Mapper;

@Mapper(config = GlobalMapperConfig.class)
public interface WeatherDataMapper {

    WeatherDataDTO toDTO(WeatherData weatherData);

    WeatherData toEntity(WeatherDataDTO weatherDataDTO);

}