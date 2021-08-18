package com.example.demo.tayma.Service;

import com.example.demo.tayma.Repo.SupportDeCoursRepo;
import com.example.demo.tayma.model.SupportDeCours;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
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
    public Optional<SupportDeCours> findSupportById (String idSQ){return supportDeCoursRepo.findById(idSQ);}

    public SupportDeCours getFile(String idSQ) {
        return supportDeCoursRepo.findById(idSQ).get();
    }

    public Stream<SupportDeCours> getAllFiles() {
        return supportDeCoursRepo.findAll().stream();
    }
}

