create table PERSONS
(
    name           char(20),
    surname        char(20),
    age            int,
    phone_number   char(10),
    city_of_living char(255),
    PRIMARY KEY (name, surname, age)
)