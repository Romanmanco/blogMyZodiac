package com.myZodiac.blogMyZodiac.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Roman Manko
 * @version 1.1
 */

@Controller
public class MainController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("title", "Главная страница");
        return "homePage";
    }

    @GetMapping("/eastGoroskopPage")
    public String eastGoroskopPage(Model model) {
        model.addAttribute("title", "Восточный гороскоп");
        return "eastGoroskopPage";
    }

    @GetMapping("/zodiacGoroskopPage")
    public String zodiacGoroskopPage(Model model) {
        model.addAttribute("title", "Зодиакальный гороскоп");
        return "zodiacGoroskopPage";
    }

    @GetMapping("/viewGoroskopPage")
    public String viewGoroskopPage(Model model) {
        model.addAttribute("title", "Узнай свой гороскоп");
        return "viewGoroskopPage";
    }
}