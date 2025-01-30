package com.example.Contact.Management.controller;

import com.example.Contact.Management.model.Contact;
import com.example.Contact.Management.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService service;

    @PostMapping
    public ResponseEntity<Contact> addContact(@Valid @RequestBody Contact contact) {
        return ResponseEntity.ok(service.addContact(contact));
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(service.getAllContacts());
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<Contact>> searchContactsByName(@RequestParam String name) {
        return ResponseEntity.ok(service.searchContactsByName(name));
    }

    @GetMapping(params = "phone")
    public ResponseEntity<List<Contact>> searchContactsByPhone(@RequestParam String phone) {
        return ResponseEntity.ok(service.searchContactsByPhone(phone));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable String id, @Valid @RequestBody Contact contact) {
        return ResponseEntity.ok(service.updateContact(id, contact));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable String id) {
        service.deleteContact(id);
        return ResponseEntity.ok("Contact deleted successfully.");
    }
}