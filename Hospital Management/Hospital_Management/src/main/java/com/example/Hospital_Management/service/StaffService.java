package com.example.Hospital_Management.service;

import com.example.Hospital_Management.model.Staff;
import com.example.Hospital_Management.repository.StaffRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public Staff createStaff(@Valid Staff staff) {
        return staffRepository.save(staff);
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Staff getStaffById(String id) {
        return staffRepository.findById(id).orElseThrow(() -> new RuntimeException("Staff not found"));
    }

    public Staff updateStaff(String id, @Valid Staff staffDetails) {
        Staff staff = getStaffById(id);
        staff.setName(staffDetails.getName());
        staff.setDesignation(staffDetails.getDesignation());
        staff.setSalary(staffDetails.getSalary());
        staff.setAddress(staffDetails.getAddress());
        return staffRepository.save(staff);
    }

    public void deleteStaff(String id) {
        staffRepository.deleteById(id);
    }

    public void deleteAllStaff() {
        staffRepository.deleteAll();
    }
}
