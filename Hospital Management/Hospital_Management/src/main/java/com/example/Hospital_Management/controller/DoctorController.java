package com.example.Hospital_Management.controller;

import com.example.Hospital_Management.model.Doctor;
import com.example.Hospital_Management.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Create a new doctor
    @PostMapping
    public ResponseEntity<String> createDoctor(@Valid @RequestBody Doctor doctor) {
        doctorService.createDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body("Doctor created successfully");
    }

    // Get all doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    // Get doctor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable String id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    // Update doctor by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateDoctor(@PathVariable String id, @Valid @RequestBody Doctor updatedDoctor) {
        doctorService.updateDoctor(id, updatedDoctor);
        return ResponseEntity.ok("Doctor updated successfully");
    }

    // Delete doctor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable String id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor deleted successfully");
    }

    // Delete all doctors
    @DeleteMapping
    public ResponseEntity<String> deleteAllDoctors() {
        doctorService.deleteAllDoctors();
        return ResponseEntity.ok("All doctors deleted successfully");
    }
}

