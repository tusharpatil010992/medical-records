package com.medical_records.controller;

import com.medical_records.dto.LoginDTO;
import com.medical_records.dto.RegisterDTO;
import com.medical_records.response.ApiResponse;
import com.medical_records.service.RegisterService;
import com.medical_records.utils.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    RegisterService registerService;

    @GetMapping("/test")
    public String test(){
        return "Hello";
    }

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;


    @PostMapping("/register")
    public ResponseEntity<ApiResponse<RegisterDTO>> registerUser(@Valid @RequestBody RegisterDTO register){
        RegisterDTO registeredUser = registerService.register(register);
        ApiResponse<RegisterDTO> apiResponse = new ApiResponse<>(true,"User registered successfully", registeredUser);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> registerUser(@Valid @RequestBody LoginDTO request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        ApiResponse<String> apiResponse = new ApiResponse<>(true,"Token", token);
        return ResponseEntity.ok(apiResponse);
    }

}
