package com.example.demo.Controller;

import com.example.demo.Repo.UserRepo;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserController {
       /* @Autowired
        PasswordEncoder passwordEncoder;*/
        @Autowired
        private UserRepo userRepo;

        @RequestMapping(value="/adduser")
        public User save(User u){
            return userRepo.save(u);
        }
        @GetMapping("/findUsers")
        public List<User> findAll()
        {return userRepo.findAll();}




    }
