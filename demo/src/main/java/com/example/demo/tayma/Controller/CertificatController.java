package com.example.demo.tayma.Controller;

import com.example.demo.tayma.Repo.CertificatRepo;
import com.example.demo.tayma.Service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
/*
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
*/
public class CertificatController {
    @Autowired
    private CertificatRepo certificatRepo;
    @Autowired
    ExportService exportService;

}
