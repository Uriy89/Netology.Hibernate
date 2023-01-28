package ru.netology.netology_hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;


@Builder
@Data
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String surname;

    @Min(0)
    @Column()
    private int age;

    @Column(length = 10, nullable = false, name = "phone_number")
    private String phoneNumber;


    @Column(nullable = false, name = "city_of_living", length = 30)
    private String city;


    public Person() {
    }

    public Person(Long id, String name, String surname, int age, String phoneNumber, String city) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.city = city;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}