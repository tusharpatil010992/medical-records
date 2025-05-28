package com.medical_records.service;

import com.medical_records.dto.RegisterDTO;
import com.medical_records.entity.User;
import com.medical_records.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public RegisterDTO register(RegisterDTO user){
        User newUser = new User();
        newUser.setTitle(user.getTitle());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setMobileNumber(user.getMobileNumber());
        newUser.setRoles(String.join(", ",List.of(user.getRoles())));
        newUser.setDepartment(user.getDepartment());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(newUser);
        return user;
    }
}
