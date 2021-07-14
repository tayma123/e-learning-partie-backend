package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApprenantService {
   @Autowired
    private ApprenantRepository apprenantRepository;
   @Secured(value={"ROLE_ADMIN"})
  @RequestMapping(value="/saveApprenant", method = RequestMethod.GET)
   public Apprenant saveApprenant(Apprenant app){
       return apprenantRepository.save(app);
   }
    @Secured(value={"ROLE_ADMIN"})
   @RequestMapping(value="/apprenants" ,method = RequestMethod.GET)
   public List<Apprenant> listApps(){
      return apprenantRepository.findAll();
   }




}
