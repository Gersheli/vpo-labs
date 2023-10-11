package org.example.level1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeopleInfoTest {
    @Test
    public void testPeopleInfoOutput() {
        String input = "John\nDoe\n25\nJane\nSmith\n30\nexit\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        PeopleInfo.main(new String[]{});

        String expectedOutput = "Список людей:\nDoe John 25\nSmith Jane 30\n\nСамый малый возраст: 25\n" +
                "Самый большой возраст: 30\nСредний возраст: 27,50";
        String actualOutput = outputStream.toString().trim().replaceAll("\\r\\n", "\n");

        assertEquals(expectedOutput, actualOutput);
    }
}