package com.myZodiac.blogMyZodiac.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class MainController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("title", "Главная страница");
        return "homePage";
    }

    @GetMapping( "/eastGoroskopPage")
    public String eastGoroskopPage(Model model){
        model.addAttribute("title", "Восточный гороскоп");
        return "eastGoroskopPage";
    }

    @GetMapping( "/zodiacGoroskopPage")
    public String zodiacGoroskopPage(Model model){
        model.addAttribute("title", "Зодиакальный гороскоп");
        return "zodiacGoroskopPage";
    }

    @GetMapping( "/viewGoroskopPage")
    public String viewGoroskopPage(Model model){
        model.addAttribute("title", "Узнай свой гороскоп");
        return "viewGoroskopPage";
    }




    //создать справочник стран
    //на странице список стран и кнопки:
    // кнопка добавления страны(она открывает страницу с формочкой для добавления)
    // кнопка редактирования страны(она открывает страницу с формочкой для редактиирования названия страны)
    // кнопка удаления страны(она открывает страницу с вопросом, точно ли удалить страну)
}