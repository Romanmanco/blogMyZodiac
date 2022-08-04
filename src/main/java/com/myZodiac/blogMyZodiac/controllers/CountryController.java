package com.myZodiac.blogMyZodiac.controllers;

import com.myZodiac.blogMyZodiac.model.entity.Country;
import com.myZodiac.blogMyZodiac.repo.CountryRepo;
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
public class CountryController {

    @Autowired
    private CountryRepo countryRepo;

    @GetMapping("/countries")
    public String getCountryTable(Model model) {
        List<Country> countryList = countryRepo.findAll();
        //добавили коллекцию в модель
        model.addAttribute("country", countryList);
        //отправили модель и вью в браузер
        return "countries";
    }

    @PostMapping("/addCountry")
    public String addCountry(@RequestParam String nameCountry,
                             Model model) {
        Country country = new Country(nameCountry);
        countryRepo.save(country);
        return "redirect:/viewGoroskopPage";
    }

    @GetMapping("/addCountryView")
    public String addCountryView(Model model) {
        return "addCountryView";
    }
}
