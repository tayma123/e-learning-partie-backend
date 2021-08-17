package com.example.demo.Service;

import com.example.demo.Repo.UserRepo;
import com.example.demo.model.User;
import com.example.demo.model.UserRegistrationDto;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiice {

   private UserRepo userRepo;

      public UserServiceImpl(UserRepo userRepo){
          super();
          this.userRepo=userRepo;
      }

      //Registration
    @Override
    public User save(UserRegistrationDto registrationDto) {
       User user = new User(registrationDto.getUsername(),registrationDto.getPassword(),registrationDto.getDateNaissance(),registrationDto.getNom(),registrationDto.getPrenom(),registrationDto.getRole());

       return userRepo.save(user);
    }
    //Find all
    public List<User> listAll() {
        return userRepo.findAll(Sort.by("username").ascending());
    }
    //delete User
    public void deleteUser(String username) {
        userRepo.deleteUserByUsername(username);

    }
    public User findByUsername (String username){
      return userRepo.findByUsername(username);
    }
}
