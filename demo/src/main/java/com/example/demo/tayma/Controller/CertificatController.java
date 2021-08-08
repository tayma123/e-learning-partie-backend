package com.example.demo.tayma.Controller;

import com.example.demo.tayma.Repository.CertificatRepo;
import com.example.demo.tayma.Services.ExportService;
import org.springframework.beans.factory.annotation.Autowired;

public class CertificatController {
    @Autowired
    private CertificatRepo certificatRepo;
    @Autowired
    ExportService exportService;

}
