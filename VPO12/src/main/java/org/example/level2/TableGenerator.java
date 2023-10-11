package org.example.level2;

import java.io.FileWriter;
import java.io.IOException;

public class TableGenerator {
    public static void main(String[] args) {
        int numRows = 10; // Количество строк в таблице
        int minColorValue = 0; // Минимальное значение цвета (черный)
        int maxColorValue = 255; // Максимальное значение цвета (белый)

        try {
            FileWriter fileWriter = new FileWriter("table.html");

            // Записываем начало HTML-файла и открываем тег таблицы с CSS-стилем
            fileWriter.write("<html>\n<body>\n<style>table { border-collapse: collapse; }</style>\n<table>\n");

            // Генерируем строки таблицы с изменяющимся фоном
            for (int i = 0; i < numRows; i++) {
                int colorValue = minColorValue + (int) ((double) i / (numRows - 1) * (maxColorValue - minColorValue));
                String colorHex = String.format("#%02x%02x%02x", colorValue, colorValue, colorValue);

                // Записываем открывающий тег строки с фоном
                fileWriter.write("<tr style=\"background-color: " + colorHex + ";\">");

                // Записываем содержимое ячеек в строке
                fileWriter.write("<td>Ячейка 1</td>");
                fileWriter.write("<td>Ячейка 2</td>");
                fileWriter.write("<td>Ячейка 3</td>");
                fileWriter.write("<td>Ячейка 4</td>");
                fileWriter.write("<td>Ячейка 5</td>");
                fileWriter.write("<td>Ячейка 6</td>");

                // Записываем закрывающий тег строки
                fileWriter.write("</tr>\n");
            }

            // Записываем закрывающий тег таблицы, тела и HTML-файла
            fileWriter.write("</table>\n</body>\n</html>");

            fileWriter.close();
            System.out.println("HTML-файл успешно сгенерирован.");
        } catch (IOException e) {
            System.out.println("Ошибка при генерации HTML-файла: " + e.getMessage());
        }
    }
}