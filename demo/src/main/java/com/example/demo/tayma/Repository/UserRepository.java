package com.example.demo.tayma.Repository;



import com.example.demo.tayma.Entities.User1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User1, Integer> {


    Optional<User1> findByUserName(String userName);
    Optional<User1> findByEmail(String email);


    User1 findOneByUserName(String userName);

    User1 findOneById(String user_id);


    User1 findByUserNameIgnoreCase(String userName);

    Optional<User1> findUserById(Long id);



}
