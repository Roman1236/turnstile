package com.example.turnstile.controllers;

import com.example.turnstile.models.User;
import com.example.turnstile.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        userService.create(user);
        return "redirect:/login";
    }
}
