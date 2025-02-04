package com.example.Hospital_Management.repository;

import com.example.Hospital_Management.model.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StaffRepository extends MongoRepository<Staff, String> {
}
