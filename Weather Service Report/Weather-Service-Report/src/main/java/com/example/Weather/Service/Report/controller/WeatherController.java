package com.example.Weather.Service.Report.controller;


import com.example.Weather.Service.Report.dto.WeatherResponseDto;
import com.example.Weather.Service.Report.service.WeatherService;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api/weather")
    public ResponseEntity<WeatherResponseDto> getWeather(@RequestParam String location) throws BadRequestException {
        WeatherResponseDto weatherResponseDto = weatherService.getWeather(location);
        return ResponseEntity.ok(weatherResponseDto);
    }
}
