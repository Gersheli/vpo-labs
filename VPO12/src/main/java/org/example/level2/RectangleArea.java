package org.example.level2;

public class RectangleArea {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Ошибка: Необходимо ввести два числа - длину и ширину прямоугольника.");
            return;
        }

        try {
            double length = Double.parseDouble(args[0]);
            double width = Double.parseDouble(args[1]);

            if (length <= 0 || width <= 0) {
                System.out.println("Ошибка: Длина и ширина прямоугольника должны быть положительными числами.");
                return;
            }

            double area = length * width;
            System.out.println("Площадь прямоугольника: " + area);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Некорректный формат чисел.");
        }
    }
}