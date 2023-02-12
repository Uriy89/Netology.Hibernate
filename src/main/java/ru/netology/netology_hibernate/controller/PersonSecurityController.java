package ru.netology.netology_hibernate.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.netology_hibernate.model.Person;
import ru.netology.netology_hibernate.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("security/persons")
public class PersonSecurityController {

    private final PersonService personService;

    public PersonSecurityController(PersonService personService) {
        this.personService = personService;
    }

    @Secured("ROLE_READ")
    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return personService.getPersonsByCity(city);
    }

    @RolesAllowed("ROLE_WRITE")
    @GetMapping("/by-age")
    public List<Person> getPersonsByAge(@RequestParam("age") int age) {
        return personService.getPersonsByAge(age);
    }

    @PreAuthorize("hasAnyRole('WRITE', 'DELETE')")
    @GetMapping("/by-name&surname")
    public List<Person> getPersonsByNameAndSurname(@RequestParam("name") String name,
                                                       @RequestParam("surname") String surname) {
        return personService.findByNameAndSurname(name, surname);
    }

    @PreAuthorize("#username == authentication.principal.username")
    @GetMapping("/hello")
    public String hello(@RequestParam String username) {
        return "Hello " + username;
    }

    @GetMapping("/")
    public String homePage() {
        return "Авторизуйся!";
    }
}