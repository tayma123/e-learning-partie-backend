package com.example.demo.tayma.Controller;
import com.example.demo.tayma.Entities.User1;
import com.example.demo.tayma.Entities.UserTest;
import com.example.demo.tayma.Repository.UserRepository;
import com.example.demo.tayma.Security.Request.LoginForm;
import com.example.demo.tayma.Security.Request.SignUpForm;
import com.example.demo.tayma.Services.ExportService;
import com.example.demo.tayma.Services.UserService;
import com.example.demo.tayma.mail.ConfirmationToken;
import com.example.demo.tayma.mail.ConfirmationTokenRepository;
import com.example.demo.tayma.mail.EmailService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/")
@RestController
@Controller
public class UserController1 {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ExportService exportService;
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;
    @Autowired
    private EmailService emailService;
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody UserTest user) {
        return userService.addUser(user);
    }
    @PostMapping("/auth/signUp")
    public ResponseEntity<?> SignUp(@RequestBody SignUpForm signUpForm) {
        return userService.signUp(signUpForm);
    }
    @PostMapping("/auth/signIn")
    public ResponseEntity<?> signIn(@RequestBody LoginForm loginForm) {
        return userService.signIn(loginForm);
    }
    @DeleteMapping("/deleteByUserName")
    public ResponseEntity<?> deleteByUserName(@RequestParam String userName) {
        return userService.deleteByUserName(userName); }
    @PostMapping("/update")
    public ResponseEntity<User1> updateUser(@RequestBody User1 user){
        User1 UpdateUser= userService.updateUser1(user);
        return new ResponseEntity<>(UpdateUser, HttpStatus.OK); }
    @GetMapping("/getAll")
    public ResponseEntity<List<User1>> getAll() {
        List<User1> users = userService.getAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("user/export/pdf")
    public ResponseEntity<InputStreamResource> exportTermsPDF() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User1> user = userRepository.findByUserName(authentication.getName());

        String firstName = user.get().getLastName();
        String lastName = user.get().getFirstName();

        ByteArrayInputStream bais = exportService.PDFReport(firstName, lastName);
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-Disposition", "inline;filename=certificate.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));

    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{userName}")
    public ResponseEntity<?> deleteUser(@PathVariable("userName") String userName){
        userService.deleteUser(userName);
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            User1 user = userRepository.findByUserNameIgnoreCase(token.getUser().getUserName());
            user.setEnabled(true);
            userRepository.save(user);
            modelAndView.setViewName("accountVerified");
        } else {
            modelAndView.addObject("message", "The link is invalid or broken!");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }


    @PutMapping("/updateByUserName/{userName}")
    public ResponseEntity<?> updateUser(@PathVariable String userName, @RequestBody User1 updatedUser) {
        return userService.updateUser(userName, updatedUser);
    }

    @GetMapping("/getByEmail")
    public ResponseEntity<?> getByEmail(@RequestParam String email) {
        return userService.getByEmail(email);
    }

    @GetMapping("/getByUserName/{userName}")
    public ResponseEntity<?> getByUserName(@PathVariable("userName") String userName) {
        return userService.getByUserName(userName);
    }

    @PreAuthorize("hasAnyAuthority({'Admin'})")
    @GetMapping("/getById}")
    public ResponseEntity<?> getById(@RequestParam int id) {
        return userService.getById(id);
    }
   
/*
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView displayRegistration(ModelAndView modelAndView, User1 user) {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(ModelAndView modelAndView, User1 user) {

        User1 existingUser = userRepository.findByUserNameIgnoreCase(user.getUserName());
        if (existingUser != null) {
            modelAndView.addObject("message", "This email already exists!");
            modelAndView.setViewName("error");
        } else {
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

            modelAndView.addObject("userName", user.getUserName());

            modelAndView.setViewName("successfulRegisteration");
        }

        return modelAndView;
    }


    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token") String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            User1 user = userRepository.findByUserNameIgnoreCase(token.getUser().getUserName());
            //user.setEnabled(true);
            userRepository.save(user);
            modelAndView.setViewName("accountVerified");
        } else {
            modelAndView.addObject("message", "The link is invalid or broken!");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }
*/

}
