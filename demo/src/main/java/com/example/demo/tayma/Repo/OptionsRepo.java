package com.example.demo.tayma.Repo;

import com.example.demo.tayma.model.Options;
import com.example.demo.tayma.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionsRepo extends JpaRepository<Options, Long>{
    List<Options> findByQuestion(Question question);
}
