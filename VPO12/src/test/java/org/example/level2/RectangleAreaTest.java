package org.example.level2;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleAreaTest {
    @Test
    public void testRectangleArea() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        String[] args = {"5", "10"};
        RectangleArea.main(args);

        String expectedOutput = "Площадь прямоугольника: 50.0\n";
        String actualOutput = outputStream.toString().replaceAll("\\r\\n", "\n");

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testInvalidArguments() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        RectangleArea.main(new String[]{});

        String expectedOutput = "Ошибка: Необходимо ввести два числа - длину и ширину прямоугольника.";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    public void testNegativeLength() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        RectangleArea.main(new String[]{"-5", "10"});

        String expectedOutput = "Ошибка: Длина и ширина прямоугольника должны быть положительными числами.";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    public void testZeroWidth() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        RectangleArea.main(new String[]{"5", "0"});

        String expectedOutput = "Ошибка: Длина и ширина прямоугольника должны быть положительными числами.";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }

    @Test
    public void testInvalidFormat() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        RectangleArea.main(new String[]{"abc", "10"});

        String expectedOutput = "Ошибка: Некорректный формат чисел.";
        assertEquals(expectedOutput, outputStream.toString().trim());
    }
}