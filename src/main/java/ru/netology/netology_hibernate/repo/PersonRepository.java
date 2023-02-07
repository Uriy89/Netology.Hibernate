package ru.netology.netology_hibernate.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.netology_hibernate.model.Person;

import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        var resultCity = entityManager.createQuery(
                        "select c from Person c where c.city = :cityName order by c.surname")
                .setParameter("cityName", city);
        return resultCity.getResultList();
    }

    @Transactional
    public List<Person> getPersonsByAge(Integer age) {
        var resultCity = entityManager.createQuery(
                        "select c from Person c where c.age < :age order by c.surname")
                .setParameter("age", age);
        return resultCity.getResultList();
    }

    @Transactional
    public List<Person> findByNameAndSurname(String name, String surname) {
        var resultCity = entityManager.createQuery(
                        "select c from Person c where c.name = :name and c.surname = :surname order by c.surname");
        resultCity.setParameter("name", name);
        resultCity.setParameter("surname", surname);
        return resultCity.getResultList();
    }
}