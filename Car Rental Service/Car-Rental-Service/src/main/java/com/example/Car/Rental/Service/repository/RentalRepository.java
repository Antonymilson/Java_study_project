package com.example.Car.Rental.Service.repository;

import com.example.Car.Rental.Service.model.Rental;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RentalRepository extends MongoRepository<Rental, String> {
    List<Rental> findByCarId(String carId);
}
