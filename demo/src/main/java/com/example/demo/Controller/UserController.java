package com.example.demo.Controller;

import com.example.demo.Repo.UserRepo;
import com.example.demo.Service.ExportService;
import com.example.demo.Service.UserServiceImpl;
import com.example.demo.model.User;
import com.example.demo.model.UserPDFExporter;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;



import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/user")
public class UserController {
       /* @Autowired
        PasswordEncoder passwordEncoder;*/
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
        public List<User> findAll()
        {return userRepo.findAll();
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

    }*/
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

    }*/
    }
