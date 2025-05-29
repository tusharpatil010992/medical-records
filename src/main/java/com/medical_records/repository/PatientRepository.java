package com.medical_records.repository;

import com.medical_records.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
