package com.myZodiac.blogMyZodiac.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("title", "Главная страница");
        return "homePage";
    }

    @GetMapping( "/registrationPage")
    public String registrationPage(Model model){
        model.addAttribute("title", "Регистрация на сайте");
        return "registrationPage";
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