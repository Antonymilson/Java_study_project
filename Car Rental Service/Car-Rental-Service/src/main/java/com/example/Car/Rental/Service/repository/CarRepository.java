package com.example.Car.Rental.Service.repository;

import com.example.Car.Rental.Service.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car, String> {

}
