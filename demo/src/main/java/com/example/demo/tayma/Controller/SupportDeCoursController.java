package com.example.demo.tayma.Controller;
import com.example.demo.tayma.storage.FileSystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SupportDeCoursController {
    @Autowired
    private FileSystemStorageService storageService;

    @RequestMapping("/upload")
    public String index()
    {
        return "addVideo";
    }


    @PostMapping("/persistVideo")
    public String  persistVideo(@RequestParam("videoFile") MultipartFile videoFile)
    {
        storageService.store(videoFile);
        return "addVideo";
    }
}
