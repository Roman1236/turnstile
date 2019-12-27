package com.example.turnstile.controllers;

import com.example.turnstile.models.User;
import com.example.turnstile.services.TurnstileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;

@Controller
public class TurnstileController {
    private TurnstileService turnstileService;

    @Autowired
    public TurnstileController(TurnstileService turnstileService) {
        this.turnstileService = turnstileService;
    }

    @GetMapping("/turnstile")
    public String turnstile(Authentication authentication, Model model) {
        User user = (User) authentication.getPrincipal();
        model.addAttribute("card", turnstileService.getCardByUser(user));
        return "turnstile";
    }

    @PostMapping("/turnstileChange")
    public String turnstileChange(Authentication authentication, Date expDate, int passCount) {
        User user = (User) authentication.getPrincipal();
        turnstileService.newUserCard(user, expDate, passCount);
        return "redirect:/turnstile";
    }

    @PostMapping("/turnstileTry")
    public String turnstileTry(Authentication authentication, Model model) {
        User user = (User) authentication.getPrincipal();
        String res = turnstileService.checkCard(user);
        model.addAttribute("status", res);
        return turnstile(authentication, model);
    }
}
