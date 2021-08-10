package com.example.demo.tayma.Security;


import com.example.demo.tayma.Entities.User1;
import com.example.demo.tayma.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User1> userOptional=userRepository.findByUserName(userName);

        if (!userOptional.isPresent())
            throw new UsernameNotFoundException("User not exist with name :" +userName);
        String pass=userOptional.get().getPassWord();



        return new org.springframework.security.core.userdetails.User (userName,pass, Collections.singleton(userOptional.get().getRole()));

    }}

