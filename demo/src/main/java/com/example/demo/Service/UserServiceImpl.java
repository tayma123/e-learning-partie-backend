package com.example.demo.Service;

import com.example.demo.Repo.UserRepo;
import com.example.demo.model.User;
import com.example.demo.model.UserRegistrationDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServiice {

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
