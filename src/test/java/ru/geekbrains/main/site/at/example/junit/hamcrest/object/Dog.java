package ru.geekbrains.main.site.at.example.junit.hamcrest.object;

import ru.geekbrains.main.site.at.example.junit.hamcrest.object.Animal;

public class Dog extends Animal {
    public Dog(String sound) {
        super(sound);
    }

    public String toString() {
        return this.sound;
    }
}