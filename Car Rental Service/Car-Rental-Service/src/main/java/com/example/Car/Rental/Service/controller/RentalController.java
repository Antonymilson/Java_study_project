package com.example.Car.Rental.Service.controller;

import com.example.Car.Rental.Service.model.Rental;
import com.example.Car.Rental.Service.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class RentalController {
    @Autowired
    private RentalService rentalService;

    @PostMapping("/{id}/rentals")
    public ResponseEntity<Rental> bookCar(@PathVariable String id, @RequestBody Rental rental) {
        rental.setCarId(id);
        return ResponseEntity.ok(rentalService.bookCar(rental));
    }

    @GetMapping("/{id}/rentals")
    public ResponseEntity<List<Rental>> getRentalsForCar(@PathVariable String id) {
        return ResponseEntity.ok(rentalService.getRentalsForCar(id));
    }
}

