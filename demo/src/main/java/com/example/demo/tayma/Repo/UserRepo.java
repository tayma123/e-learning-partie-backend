package com.example.demo.tayma.Repo;

import com.example.demo.tayma.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {
    void deleteUserById(Long id);
    User findOneByUsername(String username);

    User findOneById(String user_id);

    User findByUsername(String username);
    User findByUsernameIgnoreCase(String username);

    Optional<User> findUserById(Long id);
    @Modifying
    @Query("delete from User where username=?1")
    void deleteUserByUsername(String username);
}
