package com.example.demo.tayma.Repository;



import com.example.demo.tayma.Entities.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Transactional
public interface UserRepository extends JpaRepository<User1, Integer> {


    Optional<User1> findByUserName(String userName);
    Optional<User1> findByEmail(String email);
    Optional<User1> findOneByUserName(String userName);
    User1 getOneByUserName(String userName);
    User1 findOneById(String user_id);


    User1 findByUserNameIgnoreCase(String userName);

    Optional<User1> findUserById(Long id);


    @Modifying
    @Query("delete from User1 where userName=?1")
    void deleteUserByUserName(String userName);


}
