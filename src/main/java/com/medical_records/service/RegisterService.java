package com.medical_records.service;

import com.medical_records.dto.RegisterDTO;
import com.medical_records.entity.User;
import com.medical_records.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    public RegisterDTO register(RegisterDTO user){
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setMobileNumber(user.getMobileNumber());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        userRepository.save(newUser);
        return user;
    }
}
