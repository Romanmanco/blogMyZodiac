package com.myZodiac.blogMyZodiac.controllers;

import com.myZodiac.blogMyZodiac.model.Person;
import com.myZodiac.blogMyZodiac.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    PersonRepo personRepo;

//    @GetMapping("/profilePage")
//    public String profilePage (Model model){
//        return "/profilePage";
//    }

    @GetMapping("/getPersons")
    public String getPersons() {
        //возвращает шаблон страницы firstExample.html из папки resources/templates
        return "firstLesson/firstExample";
    }

    @GetMapping("/addPersonView")
    public String addPersonsView() {
        //отправляем страницу с формой. Без модели
        return "jpa/addPersonView";
    }

    @GetMapping("/persons")
    public String getPersonTable(Model model) {
        //получили все записи из таблицы Person и положили в коллекцию
        List<Person> personList = personRepo.findAll();
        //добавили коллекцию в модель
        model.addAttribute("person", personList);
        //отправили модель и вью в браузер
        return "jpa/persons";
    }

    @PostMapping("/addPerson")
    public String addPersons(@RequestParam String firstNameParam,
                             @RequestParam String lastNameParam,
                             @RequestParam String loginParam,
                             @RequestParam String emailParam,
                             @RequestParam String addressParam,
                             Model model) {
        //получили параметры, которые нам отправил браузер
        //заполнили этими параметрами обьект Person
        Person person = new Person(firstNameParam,lastNameParam,loginParam,emailParam,addressParam);
        //сохранили обьект Person в базу данных
        personRepo.save(person);
        return "redirect:/viewGoroskopPage";

        //получили из базы данных(таблица Person) все записи и положили их в модель
//        model.addAttribute("person", personRepo.findAll());
//        return "jpa/persons";
    }
}
