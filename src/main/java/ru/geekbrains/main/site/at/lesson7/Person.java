package ru.geekbrains.main.site.at.lesson7;

import ru.geekbrains.main.site.at.Page;

public class Person {
private String surname;
private String number;

    public Person(String surname, String number){
    this.surname=surname;
    this.number=number;
    }

    public String getName() {
        return surname;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + surname + '\'' +
                ", number=" + number +
                '}';
    }
}
