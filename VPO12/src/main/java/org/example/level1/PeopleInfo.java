package org.example.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeopleInfo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        List<String> surnames = new ArrayList<>();
        List<Integer> ages = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            String surname = scanner.nextLine();

            int age = Integer.parseInt(scanner.nextLine());

            names.add(name);
            surnames.add(surname);
            ages.add(age);
        }

        System.out.println("\nСписок людей:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(surnames.get(i) + " " + names.get(i) + " " + ages.get(i));
        }

        int minAge = Integer.MAX_VALUE;
        int maxAge = Integer.MIN_VALUE;
        int sumAge = 0;

        for (int age : ages) {
            if (age < minAge) {
                minAge = age;
            }
            if (age > maxAge) {
                maxAge = age;
            }
            sumAge += age;
        }

        double averageAge = (double) sumAge / ages.size();

        System.out.println("\nСамый малый возраст: " + minAge);
        System.out.println("Самый большой возраст: " + maxAge);
        System.out.printf("Средний возраст: %.2f", averageAge);
    }
}