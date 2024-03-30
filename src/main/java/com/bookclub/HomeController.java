package com.bookclub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String showHome() {
        return "index";
    }

    @RequestMapping("/about")
    public String showAboutUs() {
        return "about";
    }

    @RequestMapping("/contact")
    public String showContactUs() {
        return "contact";
    }
}