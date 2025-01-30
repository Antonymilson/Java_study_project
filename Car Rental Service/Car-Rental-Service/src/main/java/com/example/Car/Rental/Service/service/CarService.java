package com.example.Car.Rental.Service.service;

import com.example.Car.Rental.Service.model.Car;
import com.example.Car.Rental.Service.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Car addCar(Car car) { return carRepository.save(car); }

    public List<Car> getAllCars() { return carRepository.findAll(); }

    public Optional<Car> getCarById(String id) { return carRepository.findById(id); }

    public Car updateCar(String id, Car car) {
        car.setId(id);
        return carRepository.save(car);
    }

    public void deleteCar(String id) { carRepository.deleteById(id); }
}
