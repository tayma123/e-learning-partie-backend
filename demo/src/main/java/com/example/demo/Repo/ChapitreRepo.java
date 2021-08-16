package com.example.demo.Repo;
import com.example.demo.model.Chapitre;
import com.example.demo.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChapitreRepo extends JpaRepository<Chapitre,Long> {
    Optional<Chapitre> findChapitreByIdChap(Long idChap);
}
