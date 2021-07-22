package com.example.demo.Controller;

import com.example.demo.Repo.CertificatRepo;
import com.example.demo.Service.ExportCertificatService;
import com.example.demo.model.Certificat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.ByteArrayInputStream;
import java.util.List;

public class CertificatController {
    @Autowired
    CertificatRepo certificatRepo;
    @Autowired
    private ExportCertificatService exportCertificatService;
    @GetMapping("/export/pdf")
    @PreAuthorize("hasRole('APPRENANT') or hasRole('ADMIN')")
   public ResponseEntity<InputStreamResource> exportTermsPdf(){
        (List<Certificat>) certificats=List<Certificat> certificatRepo.findCertificatByUserId(user.get().getId());
        ByteArrayInputStream bais= exportCertificatService.certificatPDFReport(certificats);
    }


}
