package com.medical_records.controller;

import com.medical_records.dto.RegisterDTO;
import com.medical_records.entity.Patient;
import com.medical_records.response.ApiResponse;
import com.medical_records.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private PatientService patientService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<Patient>>> getAllPatients(){
        List<Patient> patients = patientService.getAllPatients();
        ApiResponse<List<Patient>> apiResponse = new ApiResponse<>(true,"Patient List", patients);
        return ResponseEntity.ok(apiResponse);
    }
}
