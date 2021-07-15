package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserServiice{

   private UserRepo userRepo;

      public UserServiceImpl(UserRepo userRepo){
          super();
          this.userRepo=userRepo;
      }
    @Override
    public User save(UserRegistrationDto registrationDto) {
       User user = new User(registrationDto.getUsername(),registrationDto.getPassword(),registrationDto.getDateNaissance(),registrationDto.getNom(),registrationDto.getPrenom(),registrationDto.getRole());

       return userRepo.save(user);
    }

}
