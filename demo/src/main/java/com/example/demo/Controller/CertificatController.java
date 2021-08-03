package com.example.demo.Controller;

import com.example.demo.Repo.CertificatRepo;
import com.example.demo.Repo.UserRepo;
import com.example.demo.Service.ExportService;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayInputStream;
import java.util.Optional;

public class CertificatController {
    @Autowired
    private CertificatRepo certificatRepo;
    @Autowired
    ExportService exportService;

}
