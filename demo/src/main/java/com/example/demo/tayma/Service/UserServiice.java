package com.example.demo.tayma.Service;

import com.example.demo.tayma.model.User;
import com.example.demo.tayma.model.UserRegistrationDto;

public interface UserServiice {
    User save(UserRegistrationDto registrationDto);

}
