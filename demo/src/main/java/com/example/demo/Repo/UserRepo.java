package com.example.demo.Repo;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {

    User findOneByUsername(String username);

    User findOneById(String user_id);

    boolean findByUsername(String username);
}
