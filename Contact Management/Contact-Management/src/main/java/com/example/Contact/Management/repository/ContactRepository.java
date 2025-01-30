package com.example.Contact.Management.repository;

import com.example.Contact.Management.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContactRepository extends MongoRepository<Contact, String> {
    List<Contact> findByNameContainingIgnoreCase(String name);
    List<Contact> findByPhone(String phone);
}