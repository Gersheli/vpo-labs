package org.example.level2;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TableGeneratorTest {
    @Test
    public void testTableGeneration() {
        TableGenerator.main(new String[]{});

        File file = new File("table.html");
        assertTrue(file.exists());
    }

    @Test
    public void testFileGenerationFailure() {
        // Передаем некорректное имя файла
        TableGenerator.main(new String[]{":,?~"});

        // Проверяем, что файл не был сгенерирован
        assertFalse(fileExists(":,?~"));
    }

    private boolean fileExists(String fileName) {
        return new File(fileName).exists();
    }
}