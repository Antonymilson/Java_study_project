package com.example.Hospital_Management.repository;

import com.example.Hospital_Management.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {
}
