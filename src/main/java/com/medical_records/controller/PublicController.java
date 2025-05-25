package com.medical_records.controller;

import com.medical_records.dto.RegisterDTO;
import com.medical_records.response.ApiResponse;
import com.medical_records.service.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    RegisterService registerService;

    @GetMapping("/test")
    public String test(){
        return "Hello";
    }


    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisterDTO>> registerUser(@Valid @RequestBody RegisterDTO register){
        RegisterDTO registeredUser = registerService.register(register);
        ApiResponse<RegisterDTO> apiResponse = new ApiResponse<>(true,"User registered successfully", registeredUser);
        return ResponseEntity.ok(apiResponse);
    }

}
