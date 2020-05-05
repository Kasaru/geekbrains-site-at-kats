package ru.geekbrains.main.site.at.lesson7;

import java.util.ArrayList;
import java.util.List;


public class PhoneBook {

    public static void main(String[] args) {
        List<Person> book= new ArrayList<>();
        book.add(new Person("Иванов", "1"));
        book.add(new Person("Cмирнов","2"));
        book.add(new Person("Сидоров","4"));
        book.add(new Person("Иванов", "3"));

            System.out.println(book.get(0));



    }
}
