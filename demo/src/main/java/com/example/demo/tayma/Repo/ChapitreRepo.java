package com.example.demo.tayma.Repo;
import com.example.demo.tayma.model.Chapitre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChapitreRepo extends JpaRepository<Chapitre,Long> {
    Optional<Chapitre> findChapitreByIdChap(Long idChap);
}
