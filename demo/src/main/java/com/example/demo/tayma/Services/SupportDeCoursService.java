package com.example.demo.tayma.Services;

import com.example.demo.tayma.Repository.SupportDeCoursRepo;
import com.example.demo.tayma.Entities.SupportDeCours;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;
@Service
public class SupportDeCoursService {
    private final SupportDeCoursRepo supportDeCoursRepo;

    public SupportDeCoursService(SupportDeCoursRepo supportDeCoursRepo) {
        this.supportDeCoursRepo = supportDeCoursRepo;
    }


    public SupportDeCours store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        SupportDeCours FileDB = new SupportDeCours(fileName, file.getContentType());

        return supportDeCoursRepo.save(FileDB);
    }

    public SupportDeCours getFile(String id) {
        return supportDeCoursRepo.findById(id).get();
    }

    public Stream<SupportDeCours> getAllFiles() {
        return supportDeCoursRepo.findAll().stream();
    }
}

