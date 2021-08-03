package com.example.demo.Repo;

import com.example.demo.model.Certificat;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.security.cert.Certificate;
import java.util.Optional;

public interface  CertificatRepo  extends JpaRepository<Certificat,Long> {




}
