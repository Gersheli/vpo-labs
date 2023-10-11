package org.example.level3;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileSearchTest {
    @Test
    public void testFileSearch() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        FileSearch.main(new String[]{"C:\\Users\\Victor\\IdeaProjects\\VPO12", ".svg"});
        //C:\Users\Victor\IdeaProjects\VPO12\logo-3.svg

        String expectedOutput = "";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testInvalidFolderPath() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String folderPath = "`!&?:";
        String fileExtension = ".b67r";

        FileSearch.main(new String[]{folderPath, fileExtension});

        String expectedOutput = "Ошибка: Указанная папка не существует или не является директорией.\n";
        assertEquals(expectedOutput, outputStream.toString().replaceAll("\\r\\n", "\n"));
    }

    @Test
    public void testInvalidArguments() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        FileSearch.main(new String[]{});

        String expectedOutput = "Ошибка: Необходимо указать путь к папке и расширение файла.\n";
        assertEquals(expectedOutput, outputStream.toString().replaceAll("\\r\\n", "\n"));
    }

    @Test
    public void testNoFilesFound() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String folderPath = "path/to/empty/folder";
        String fileExtension = ".txt";

        FileSearch.main(new String[]{folderPath, fileExtension});

        String expectedOutput = "Ошибка: Указанная папка не существует или не является директорией.\n";
        assertEquals(expectedOutput, outputStream.toString().replaceAll("\\r\\n", "\n"));
    }

    @Test
    public void testInvalidFileExtension() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String folderPath = "path/to/folder";
        String fileExtension = ".doc";

        FileSearch.main(new String[]{folderPath, fileExtension});

        String expectedOutput = "Ошибка: Указанная папка не существует или не является директорией.\n";
        assertEquals(expectedOutput, outputStream.toString().replaceAll("\\r\\n", "\n"));
    }

    @Test
    public void testSearchFiles_FolderDoesNotContainFilesWithExtension() {
        // Arrange
        File folder = new File("C:\\EmptyFolder");
        String fileExtension = ".pdf";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        FileSearch.searchFiles(folder, fileExtension);
        String output = outputStream.toString().trim();

        // Assert
        assertEquals("", output);
    }
}