package ru.netology.netology_hibernate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.netology_hibernate.model.Person;
import ru.netology.netology_hibernate.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return personService.getPersonsByCity(city);
    }

    @RequestMapping("/by-age")
    public List<Person> getPersonsByAge(@RequestParam("age") int age) {
        return personService.getPersonsByAge(age);
    }

    @RequestMapping("/by-name&surname")
    public List<Person> getPersonsByNameAndSurname(@RequestParam("name") String name,
                                                       @RequestParam("surname") String surname) {
        return personService.findByNameAndSurname(name, surname);
    }

    @RequestMapping("/")
    public String homePage() {
        return "Авторизуйся!";
    }


}
