package com.example.demo.Service;

import com.example.demo.model.User;
import com.example.demo.model.UserRegistrationDto;

public interface UserServiice {
    User save(UserRegistrationDto registrationDto);

}
