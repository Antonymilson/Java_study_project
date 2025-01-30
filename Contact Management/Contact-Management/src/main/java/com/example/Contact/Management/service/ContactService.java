package com.example.Contact.Management.service;

import com.example.Contact.Management.model.Contact;
import com.example.Contact.Management.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    public Contact addContact(Contact contact) {
        return repository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    public List<Contact> searchContactsByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<Contact> searchContactsByPhone(String phone) {
        return repository.findByPhone(phone);
    }

    public Optional<Contact> getContactById(String id) {
        return repository.findById(id);
    }

    public Contact updateContact(String id, Contact contact) {
        contact.setId(id);
        return repository.save(contact);
    }

    public void deleteContact(String id) {
        repository.deleteById(id);
    }
}