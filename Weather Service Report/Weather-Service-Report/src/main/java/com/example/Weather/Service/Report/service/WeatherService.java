package com.example.Weather.Service.Report.service;


import com.example.Weather.Service.Report.dto.WeatherResponseDto;
import com.example.Weather.Service.Report.model.Weather;
import com.example.Weather.Service.Report.repository.WeatherRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Optional;

@Service
public class WeatherService {
    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;

    private final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    private final String API_KEY = "your_api_key";

    public WeatherService(WeatherRepository weatherRepository, RestTemplate restTemplate) {
        this.weatherRepository = weatherRepository;
        this.restTemplate = restTemplate;
    }

    public WeatherResponseDto getWeather(String location) throws BadRequestException {
        if (location == null || location.isEmpty()) {
            throw new BadRequestException("Location cannot be null or empty.");
        }

        // Check if data exists in MongoDB
        Optional<Weather> cachedWeather = weatherRepository.findByLocation(location);
        if (cachedWeather.isPresent() && isDataRecent(cachedWeather.get())) {
            Weather weather = cachedWeather.get();
            return mapToDto(weather);
        }

        // Fetch from API if not cached or outdated
        try {
            String url = String.format("%s?q=%s&appid=%s&units=metric", API_URL, location, API_KEY);
            WeatherResponseDto apiResponse = restTemplate.getForObject(url, WeatherResponseDto.class);

            // Save to MongoDB
            Weather weather = new Weather();
            weather.setLocation(location);
            weather.setWeatherDescription(apiResponse.getWeather().get(0).getDescription());
            weather.setTemperature(apiResponse.getMain().getTemp());
            weather.setTimestamp(Instant.now().getEpochSecond());
            weatherRepository.save(weather);

            return apiResponse;
        } catch (Exception ex) {
            throw new BadRequestException("Failed to fetch weather data.");
        }
    }

    private boolean isDataRecent(Weather weather) {
        long currentTime = Instant.now().getEpochSecond();
        return currentTime - weather.getTimestamp() < 3600; // Data is recent if less than an hour old
    }

    private WeatherResponseDto mapToDto(Weather weather) {
        WeatherResponseDto dto = new WeatherResponseDto();
        dto.setLocation(weather.getLocation());
//        dto.setWeatherDescription(weather.getWeatherDescription());
//        dto.setTemperature(weather.getTemperature());
        return dto;
    }
}