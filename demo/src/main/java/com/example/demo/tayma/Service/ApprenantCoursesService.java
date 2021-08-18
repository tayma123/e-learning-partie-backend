package com.example.demo.tayma.Service;
import com.example.demo.tayma.model.ApprenantCourses;
import com.example.demo.tayma.Exception.QuestionNotFoundException;
import com.example.demo.tayma.Repo.ApprenantCoursesRepo;
import com.example.demo.tayma.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ApprenantCoursesService {
    private ApprenantCoursesRepo apprenantCoursesRepo;
    @Autowired
    public ApprenantCoursesService(ApprenantCoursesRepo apprenantCoursesRepo) {
            this.apprenantCoursesRepo = apprenantCoursesRepo;
    }


    public ApprenantCourses findById(Long idAC) {
        return  apprenantCoursesRepo.findById(idAC).orElseThrow(() -> new QuestionNotFoundException("Inscription Not Found!!"));
    }
    public List<ApprenantCourses> findAll() {
        return apprenantCoursesRepo.findAll();
    }
    public List<ApprenantCourses> findByUser(User user) {
        return apprenantCoursesRepo.findByUser(user);
    }
    public ApprenantCourses save(ApprenantCourses apprenantCourses) {
        return apprenantCoursesRepo.save(apprenantCourses);
    }
    public void delete(Long idAC) {
        apprenantCoursesRepo.deleteById(idAC);
    }
    public ApprenantCourses update(ApprenantCourses apprenantCourses) {
        return apprenantCoursesRepo.save(apprenantCourses);
    }
}
