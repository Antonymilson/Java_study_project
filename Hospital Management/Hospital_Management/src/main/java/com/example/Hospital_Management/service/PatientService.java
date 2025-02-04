package com.example.Hospital_Management.service;


import com.example.Hospital_Management.model.Patient;
import com.example.Hospital_Management.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(@Valid Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(String id) {
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    public Patient updatePatient(String id, @Valid Patient patientDetails) {
        Patient patient = getPatientById(id);
        patient.setName(patientDetails.getName());
        patient.setAge(patientDetails.getAge());
        patient.setSex(patientDetails.getSex());
        patient.setAddress(patientDetails.getAddress());
        return patientRepository.save(patient);
    }

    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }

    public void deleteAllPatients() {
        patientRepository.deleteAll();
    }
}

