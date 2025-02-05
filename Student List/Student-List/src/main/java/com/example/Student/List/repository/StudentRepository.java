package com.example.Student.List.repository;

import com.example.Student.List.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

}