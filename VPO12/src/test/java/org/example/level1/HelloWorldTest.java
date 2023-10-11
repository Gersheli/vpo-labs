package org.example.level1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldTest {
    @Test
    public void testHelloWorldOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        int numExclamationMarks = HelloWorld.main(new String[]{});

        String expectedOutput = "Hello, world!\nAndhiagain!\n" + "!".repeat(numExclamationMarks) + "\n";
        String actualOutput = outputStream.toString().replaceAll("\\r\\n", "\n");

        assertEquals(expectedOutput, actualOutput);
    }
}