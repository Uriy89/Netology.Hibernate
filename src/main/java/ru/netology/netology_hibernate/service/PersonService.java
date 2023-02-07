package ru.netology.netology_hibernate.service;


import org.springframework.stereotype.Service;
import ru.netology.netology_hibernate.model.Person;
import ru.netology.netology_hibernate.repo.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersonsByCity(String city) {
        return personRepository.getPersonsByCity(city);
    }
    public List<Person> getPersonsByAge(Integer age) {
        return personRepository.getPersonsByAge(age);
    }
    public List<Person> findByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }
}