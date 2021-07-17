package com.example.demo.Controller;

import com.example.demo.Service.UserServiice;
import com.example.demo.model.UserRegistrationDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/registration")
public class UserRegistrationController {
    private UserServiice userServiice;

    public UserRegistrationController(UserServiice userServiice) {
        super();
        this.userServiice = userServiice;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userServiice.save(registrationDto);
        return "redirect:/registration?success";

    }
}
