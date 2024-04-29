package com.bookclub.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        // Add logout logic here
        return "redirect:/login?logout"; // Redirect to login page with logout parameter
    }
}
