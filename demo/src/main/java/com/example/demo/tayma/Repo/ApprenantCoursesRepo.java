package com.example.demo.tayma.Repo;
import com.example.demo.tayma.model.ApprenantCourses;
import com.example.demo.tayma.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApprenantCoursesRepo extends JpaRepository<ApprenantCourses,Long> {

    List<ApprenantCourses> findByUser(User user);
}
