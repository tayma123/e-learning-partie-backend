package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@Secured(value="ROLE_ADMIN")
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @RequestMapping(value="/adduser")
    public User save(User u){
        return userRepo.save(u);
    }
    @GetMapping("/findUsers")
    public List<User> findAll()
    {return userRepo.findAll();}
    @RequestMapping(value="/addrole")
    public Role saveRole(Role role){
        return roleRepo.save(role);
    }
    @GetMapping("/findRoles")
    public List<Role> findAllRoles()
    {return roleRepo.findAll();}
    @RequestMapping(value="/addRoleToUser")
   public User addRoleToUser(String username,String role){

       User u = userRepo.findOneByUsername(username);
        Role r= roleRepo.findOneByRole(role);
      u.getRoles().add(r);
      userRepo.save(u);
      return u;
   }

}

