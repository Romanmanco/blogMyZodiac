package com.myZodiac.blogMyZodiac.controllers;

import com.myZodiac.blogMyZodiac.model.entity.Person;
import com.myZodiac.blogMyZodiac.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Roman Manko
 * @version 1.1
 */

@Controller
public class PersonController {

    @Autowired
    PersonRepo personRepo;

    @GetMapping("/profilePage")
    public String profilePage(Model model) {
        return "/profilePage";
    }

    @GetMapping("/getPersons")
    public String getPersons() {
        return "firstLesson/firstExample";
    }

    @GetMapping("/addPersonView")
    public String addPersonsView() {
        return "jpa/addPersonView";
    }

    @GetMapping("/persons")
    public String getPersonTable(Model model) {
        List<Person> personList = personRepo.findAll();
        model.addAttribute("person", personList);
        return "jpa/persons";
    }

    @PostMapping("/addPerson")
    public String addPersons(@RequestParam String firstNameParam,
                             @RequestParam String lastNameParam,
                             @RequestParam String loginParam,
                             @RequestParam String emailParam,
                             @RequestParam String addressParam,
                             Model model) {
        Person person = new Person(firstNameParam, lastNameParam, loginParam, emailParam, addressParam);
        personRepo.save(person);
        return "redirect:/viewGoroskopPage";
    }
}
