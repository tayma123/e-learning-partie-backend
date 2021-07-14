package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,String> {


    Role findOneByRole(String role);
}
