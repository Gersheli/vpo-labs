package org.example.level1;

import java.util.Random;

public class HelloWorld {
    public static int main(String[] args) {
        System.out.println("Hello, world!");
        System.out.println("Andhiagain!");

        Random random = new Random();
        int numExclamationMarks = random.nextInt(46) + 5; // Генерируем случайное число от 5 до 50
        String exclamationMarks = "!".repeat(numExclamationMarks);
        System.out.println(exclamationMarks);

        return numExclamationMarks;
    }
}