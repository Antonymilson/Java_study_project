package com.example.Hospital_Management.controller;


import com.example.Hospital_Management.model.Staff;
import com.example.Hospital_Management.service.StaffService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @PostMapping
    public ResponseEntity<Staff> createStaff(@Valid @RequestBody Staff staff) {
        return ResponseEntity.ok(staffService.createStaff(staff));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaff(@PathVariable String id) {
        return ResponseEntity.ok(staffService.getStaffById(id));
    }

    @GetMapping
    public ResponseEntity<List<Staff>> getAllStaff() {
        return ResponseEntity.ok(staffService.getAllStaff());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable String id, @Valid @RequestBody Staff staffDetails) {
        return ResponseEntity.ok(staffService.updateStaff(id, staffDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable String id) {
        staffService.deleteStaff(id);
        return ResponseEntity.ok("Staff deleted successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAllStaff() {
        staffService.deleteAllStaff();
        return ResponseEntity.ok("All staff deleted successfully");
    }
}