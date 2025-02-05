package com.example.Weather.Service.Report.repository;


import com.example.Weather.Service.Report.model.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WeatherRepository extends MongoRepository<Weather, String> {
    Optional<Weather> findByLocation(String location);
}