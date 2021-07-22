package com.example.demo.Repo;

import com.example.demo.model.Certificat;
import com.example.demo.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificatRepo  extends JpaRepository<Certificat,Long> {
}
