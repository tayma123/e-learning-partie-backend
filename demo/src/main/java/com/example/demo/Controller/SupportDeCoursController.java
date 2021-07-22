package com.example.demo.Controller;
import com.example.demo.storage.FileSystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SupportDeCoursController {
    @Autowired
    private FileSystemStorageService storageService;

    @RequestMapping("/")
    public String index()
    {
        return "addVideo";
    }

    @GetMapping("/addVideo")
    public String  addVideo()
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
