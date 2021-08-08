package com.example.demo.tayma.storage;

import com.example.demo.tayma.Repository.SupportDeCoursRepo;
import com.example.demo.tayma.Entities.SupportDeCours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemStorageService implements StorageService
{
    private final Path rootLocation;
    private final SupportDeCoursRepo supportDeCoursRepo;
    @Autowired
    public FileSystemStorageService(StorageProperties properties, SupportDeCoursRepo supportDeCoursRepo) {
        this.rootLocation = Paths.get(properties.getUploadDir()).toAbsolutePath().normalize();
        this.supportDeCoursRepo = supportDeCoursRepo;
        try {
            Files.createDirectories(this.rootLocation);
        } catch (Exception ex) {
            throw new StorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    @Override
    public String store(MultipartFile file)
    {
        // Normalize file name
        String fileName = "D:/PFA/"+StringUtils.cleanPath(file.getOriginalFilename());
        try
        {   SupportDeCours FileDB = new SupportDeCours(fileName,file.getContentType());

         supportDeCoursRepo.save(FileDB);
            if (file.isEmpty())
            {
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.rootLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        }
        catch (IOException e)
        {
            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
        }
    }
    @Override
    public void init()
    {
        try
        {
            Files.createDirectory(rootLocation);
        }
        catch (IOException e)
        {
            throw new StorageException("Could not initialize storage", e);
        }
    }
}
