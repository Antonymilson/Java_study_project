package com.example.Hospital_Management.repository;
import com.example.Hospital_Management.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
}

