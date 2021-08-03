package com.example.demo.Repo;

import com.example.demo.model.Options;
import com.example.demo.model.Question;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionsRepo extends JpaRepository<Options, Long>{

}
