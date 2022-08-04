package com.myZodiac.blogMyZodiac.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Roman Manko
 * @version 1.1
 */

@Controller
public class UserController {

    @GetMapping("/registrarionPage")
    public String registrarionPage(Model model) {
        model.addAttribute("title", "Регистрация");
        return "registrarionPage";
    }
}
