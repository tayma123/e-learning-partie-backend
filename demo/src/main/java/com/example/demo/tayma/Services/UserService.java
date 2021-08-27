package com.example.demo.tayma.Services;



import com.example.demo.tayma.Entities.User1;
import com.example.demo.tayma.Entities.UserTest;
import com.example.demo.tayma.Repository.UserRepository;
import com.example.demo.tayma.Security.JwtUtils;
import com.example.demo.tayma.Security.Request.LoginForm;
import com.example.demo.tayma.Security.Request.SignUpForm;
import com.example.demo.tayma.Security.Response.SignInResponse;
import com.example.demo.tayma.mail.ConfirmationToken;
import com.example.demo.tayma.mail.ConfirmationTokenRepository;
import com.example.demo.tayma.mail.EmailService;
import com.example.demo.tayma.utils.ErrorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Configuration
@Transactional
@EnableWebSecurity
public class UserService {
    @Autowired
    UserRepository userRepository;
 @Autowired
 ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    EmailService emailService;
    @Autowired
    JwtUtils jwtUtils ;
    @Autowired
    AuthenticationManager authenticationManager;
    public ResponseEntity<?> addUser(UserTest userTest){
        User1 user=new User1();
        user.setEmail(userTest.getEmail());
        user.setFirstName(userTest.getFirstName());
        user.setLastName(userTest.getLastName());
        user.setGender(userTest.getGender());
        user.setAdress(userTest.getAdress());
        String password = passwordEncoder().encode(userTest.getPassWord());
        user.setPassWord(password);
        user.setRole(userTest.getRole());
        user.setTelephone(userTest.getTelephone());
        user.setUserName(userTest.getUserName());
        user.setEnabled(true);
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
            user.setEnabled(false);
            userRepository.save(user);
             ConfirmationToken confirmationToken = new ConfirmationToken(user);
            confirmationTokenRepository.save(confirmationToken);
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getUserName());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("taymabenhmida1@gmailcom");
            mailMessage.setText("To confirm your account, please click here : "
                    + "http://localhost:8080/confirm-account?token=" + confirmationToken.getConfirmationToken());

            emailService.sendEmail(mailMessage);
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
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginform.getUserName(), loginform.getPassWord()));
        String jwt = jwtUtils.generateToken(loginform.getUserName());
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return new ResponseEntity<>(new SignInResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()),HttpStatus.ACCEPTED); }

    public User1 updateUser1(User1 user) {
        String password = passwordEncoder().encode(user.getPassWord());
        user.setPassWord(password);
        return userRepository.save(user);
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
    public ResponseEntity<?> updateUser(String userName, User1 updatedUser) {
        Optional<User1> UserOptional = userRepository.findOneByUserName(userName);

        User1 databaseUser = UserOptional.get();
        databaseUser.setFirstName(updatedUser.getFirstName());
        databaseUser.setGender(updatedUser.getGender());
        databaseUser.setAdress(updatedUser.getAdress());
        databaseUser.setTelephone(updatedUser.getTelephone());
        databaseUser.setLastName(updatedUser.getLastName());
        String password = passwordEncoder().encode(updatedUser.getPassWord());
        databaseUser.setPassWord(password);
        databaseUser.setEmail(updatedUser.getEmail());
        databaseUser.setUserName(updatedUser.getUserName());
        databaseUser.setRole(updatedUser.getRole());
        userRepository.save(databaseUser);
        return new ResponseEntity<>(HttpStatus.OK);
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
        return new ResponseEntity<>(new ErrorModel("User Deleted"),HttpStatus.OK); }
    public List<User1>getAll(){ return  userRepository.findAll(); }
    public void deleteUser(String userName) { userRepository.deleteUserByUserName(userName); }

   }
