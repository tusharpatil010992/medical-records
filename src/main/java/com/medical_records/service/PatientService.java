package com.medical_records.service;

import com.medical_records.entity.Patient;
import com.medical_records.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients(){
        List<Patient> all = patientRepository.findAll();
        return all;
    }
}
