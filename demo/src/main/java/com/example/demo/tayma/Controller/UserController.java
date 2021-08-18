package com.example.demo.tayma.Controller;
/*
import com.example.demo.tayma.Repo.UserRepo;
import com.example.demo.tayma.Service.ExportService;
import com.example.demo.tayma.Service.UserServiceImpl;

import com.example.demo.tayma.mail.ConfirmationToken;
import com.example.demo.tayma.mail.ConfirmationTokenRepository;
import com.example.demo.tayma.mail.EmailService;
import com.example.demo.tayma.model.Cours.Cours;
import com.example.demo.tayma.model.User;
import com.example.demo.tayma.model.UserPDFExporter;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class UserController {
    /*
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private EmailService emailService;

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public ModelAndView displayRegistration(ModelAndView modelAndView, User user)
    {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }



    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView registerUser(ModelAndView modelAndView, User user)
    {

        User existingUser = userRepo.findByUsernameIgnoreCase(user.getUsername());
        if(existingUser != null)
        {
            modelAndView.addObject("message","This email already exists!");
            modelAndView.setViewName("error");
        }
        else
        {
            userRepo.save(user);

            ConfirmationToken confirmationToken = new ConfirmationToken(user);

            confirmationTokenRepository.save(confirmationToken);

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(user.getUsername());
            mailMessage.setSubject("Complete Registration!");
            mailMessage.setFrom("taymabenhmida1@gmailcom");
            mailMessage.setText("To confirm your account, please click here : "
                    +"http://localhost:8080/confirm-account?token="+confirmationToken.getConfirmationToken());

            emailService.sendEmail(mailMessage);

            modelAndView.addObject("username", user.getUsername());

            modelAndView.setViewName("successfulRegisteration");
        }

        return modelAndView;
    }


    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam("token")String confirmationToken)
    {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            User user = userRepo.findByUsernameIgnoreCase(token.getUser().getUsername());
            user.setEnabled(true);
            userRepo.save(user);
            modelAndView.setViewName("accountVerified");
        }
        else
        {
            modelAndView.addObject("message","The link is invalid or broken!");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }*/
    /* @Autowired
     PasswordEncoder passwordEncoder;*/
/*
    @Autowired
    UserServiceImpl userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    ExportService exportService;

    @RequestMapping(value="/add")
    public User save(User u){
        return userRepo.save(u);
    }
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllusers(){
        List<User> users=userService.listAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    /*@GetMapping("export/pdf")
    @PreAuthorize("hasRole('APPRENANT'),hasRole('ADMIN')")
    public ResponseEntity<InputStreamResource> exportTermsPDF() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = userRepo.findByUsername(authentication.getName());
        String nom = user.get().getNom();
        String prenom=user.get().getPrenom();
        ByteArrayInputStream bais = exportService.PDFReport(nom,prenom);
        HttpHeaders headers=new HttpHeaders();
        headers.add("content-Disposition","inline;filename=certificate.pdf");
        return  ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bais));
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable("username") String username){
        userService.deleteUser(username);
        return new ResponseEntity<>( HttpStatus.OK); }


/*@GetMapping("/users/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        List<User> listUsers = userService.listAll();
        UserPDFExporter exporter = new UserPDFExporter(listUsers);
        exporter.export(response);
    }
}

 */