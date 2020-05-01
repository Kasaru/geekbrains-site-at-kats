package ru.geekbrains.main.site.at.lesson7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson7 {
    public static void main(String[] args) {
        String[] words = {"1", "2", "3", "1", "1", "2", "4", "5", "6", "7", "8", "9", "10", "11", "11", "12", "13", "14", "15", "16"};
        ArrayList<String> unicue = new ArrayList<String>(Arrays.asList(words));

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i] == words[j]) {
                    unicue.remove(words[i]);
                    unicue.remove(words[j]);
                }
            }
        }
        System.out.println("Уникальные слова: " + unicue);
    }
}
