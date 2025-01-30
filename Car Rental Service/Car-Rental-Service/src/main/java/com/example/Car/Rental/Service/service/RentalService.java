package com.example.Car.Rental.Service.service;

import com.example.Car.Rental.Service.model.Rental;
import com.example.Car.Rental.Service.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;

    public Rental bookCar(Rental rental) { return rentalRepository.save(rental); }

    public List<Rental> getRentalsForCar(String carId) {
        return rentalRepository.findByCarId(carId);
    }
}
