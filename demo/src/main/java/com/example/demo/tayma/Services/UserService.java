package com.example.demo.tayma.Services;



import com.example.demo.tayma.Entities.User1;
import com.example.demo.tayma.Entities.UserTest;
import com.example.demo.tayma.Repository.UserRepository;
import com.example.demo.tayma.Security.JwtUtils;
import com.example.demo.tayma.Security.Request.LoginForm;
import com.example.demo.tayma.Security.Request.SignUpForm;
import com.example.demo.tayma.Security.Response.SignInResponse;
import com.example.demo.tayma.utils.ErrorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Configuration

@EnableWebSecurity
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtils jwtUtils ;
    @Autowired
    AuthenticationManager authenticationManager;

    public ResponseEntity<?> addUser(UserTest userTest){



        User1 user=new User1();
        if (userRepository.findByUserName(userTest.getUserName()).isPresent()){
            return  new ResponseEntity<>(new ErrorModel("user name is used"),HttpStatus.BAD_REQUEST);
        }
        if (userRepository.findByEmail(userTest.getEmail()).isPresent()){
            return  new ResponseEntity<>(new ErrorModel(" Email is  used"),HttpStatus.BAD_REQUEST);
        }
        if(!isValidEmailAddress(userTest.getEmail())){
            return  new ResponseEntity<>(new ErrorModel("Invalid email"),HttpStatus.BAD_REQUEST);
        }

        user.setEmail(userTest.getEmail());
        if (userTest.getFirstName().length()==0){
            return  new ResponseEntity<>(new ErrorModel("UserName is empty"),HttpStatus.BAD_REQUEST); }
        user.setFirstName(userTest.getFirstName());
        if (userTest.getLastName().length()==0){
            return  new ResponseEntity<>(new ErrorModel("LastName is empty"),HttpStatus.BAD_REQUEST); }
        user.setLastName(userTest.getLastName());
        user.setGender(userTest.getGender());
        user.setAdress(userTest.getAdress());



        if (userTest.getPassWord().length()<5){
            return  new ResponseEntity<>(new ErrorModel("Short PassWord"),HttpStatus.BAD_REQUEST); }
        String password = passwordEncoder().encode(userTest.getPassWord());
        user.setPassWord(password);
        user.setRole(userTest.getRole());
        user.setTelephone(userTest.getTelephone());

        user.setUserName(userTest.getUserName());

        userRepository.save(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    public ResponseEntity<?> signUp (SignUpForm signUpForm){


        if (userRepository.findByUserName(signUpForm.getUserName()).isPresent()){
            return  new ResponseEntity<>(new ErrorModel("user name is used"),HttpStatus.BAD_REQUEST);
        }
        if (userRepository.findByEmail(signUpForm.getEmail()).isPresent()){
            return  new ResponseEntity<>(new ErrorModel(" Email is  used"),HttpStatus.BAD_REQUEST);
        }
        if(!isValidEmailAddress(signUpForm.getEmail())){
            return  new ResponseEntity<>(new ErrorModel("Invalid email"),HttpStatus.BAD_REQUEST);
        }

        else {
            User1 user = new User1();
            user.setFirstName(signUpForm.getFirstName());
            user.setLastName(signUpForm.getLastName());
            user.setUserName(signUpForm.getUserName());
            user.setTelephone(signUpForm.getTelephone());
            user.setAdress(signUpForm.getAdress());
            user.setEmail(signUpForm.getEmail());
            user.setGender(signUpForm.getGender());
            user.setRole(signUpForm.getRole());
            String password = passwordEncoder().encode(signUpForm.getPassWord());
            user.setPassWord(password);

            userRepository.save(user);
        }


        String token= jwtUtils.generateToken(signUpForm.getUserName());
        return new ResponseEntity<>(signUpForm.getRole(),HttpStatus.OK);






    }


    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public ResponseEntity<?> signIn ( LoginForm loginform) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginform.getUserName(), loginform.getPassWord()));


        String jwt = jwtUtils.generateToken(loginform.getUserName());
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return new ResponseEntity<>(new SignInResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()),HttpStatus.ACCEPTED);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public ResponseEntity<?> deleteByUserName(String userName){
        if(!userRepository.findByUserName(userName).isPresent())
            return new ResponseEntity<>(new ErrorModel("User Not Found"),HttpStatus.BAD_REQUEST);
        int id=userRepository.findByUserName(userName).get().getId();
        userRepository.deleteById(id);
        return new ResponseEntity<>(new ErrorModel("User Deleted"),HttpStatus.OK);

    }
    public ResponseEntity<?> getByUserName(String userName){
        if(!userRepository.findByUserName(userName).isPresent())
            return new ResponseEntity<>(new ErrorModel("User Not Found"),HttpStatus.BAD_REQUEST);
        Optional<User1> user=userRepository.findByUserName(userName);
        return new ResponseEntity<>(user.get(),HttpStatus.OK);

    }
    public ResponseEntity<?> getById(int id){
        if(!userRepository.findById(id).isPresent())
            return new ResponseEntity<>(new ErrorModel("User Not Found"),HttpStatus.BAD_REQUEST);
        User1 user=userRepository.findById(id).get();
        return new ResponseEntity<>(user,HttpStatus.OK);

    }
    public ResponseEntity<?> getByEmail(String email){
        if(!userRepository.findByEmail(email).isPresent())
            return new ResponseEntity<>(new ErrorModel("User Not Found"),HttpStatus.BAD_REQUEST);
        User1 user=userRepository.findByEmail(email).get();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    public ResponseEntity<?> updateUser(int id, User1 updatedUser) {
        Optional<User1> UserOptional = userRepository.findById(id);
        if(!UserOptional.isPresent())
            return new ResponseEntity<>(new ErrorModel("wrong user id "),HttpStatus.BAD_REQUEST);

        User1 databaseUser = UserOptional.get();

        if(updatedUser.getFirstName() != null)
            if (updatedUser.getFirstName().length() < 3)
                return new ResponseEntity<>(new ErrorModel("wrong user name"),HttpStatus.BAD_REQUEST);
            else
                databaseUser.setFirstName(updatedUser.getFirstName());

        if(updatedUser.getLastName() != null)
            if (updatedUser.getLastName().length() < 3)
                return new ResponseEntity<>(new ErrorModel("Invalid LastName"),HttpStatus.BAD_REQUEST);
            else
                databaseUser.setLastName(updatedUser.getLastName());

        if (updatedUser.getPassWord().length()<5){
            return  new ResponseEntity<>(new ErrorModel("Short PassWord"),HttpStatus.BAD_REQUEST); }
        String password = passwordEncoder().encode(updatedUser.getPassWord());
        databaseUser.setPassWord(password);


        if (userRepository.findByEmail(updatedUser.getEmail()).isPresent()){
            return  new ResponseEntity<>(new ErrorModel(" Email is  used"),HttpStatus.BAD_REQUEST); }

        if(!isValidEmailAddress(updatedUser.getEmail())){
            return  new ResponseEntity<>(new ErrorModel("Invalid email"),HttpStatus.BAD_REQUEST);
        }
        databaseUser.setEmail(updatedUser.getEmail());



        userRepository.save(databaseUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public List<User1>getAll(){
        return  userRepository.findAll();

    }


}