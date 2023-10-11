package org.example.level3;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DocumentDownloaderTest {
    @Test
    public void testDocumentDownload() throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String url = "https://static.rutracker.cc/logo/logo-3.svg";
        String folderPath = "C:\\Users\\Victor\\IdeaProjects\\VPO12";

        DocumentDownloader.main(new String[]{url, folderPath});

        String expectedOutput = "Документ успешно сохранен.\n";
        assertEquals(expectedOutput, outputStream.toString().replaceAll("\\r\\n", "\n"));

        Path filePath = Paths.get(folderPath, "logo-3.svg");
        assertTrue(Files.exists(filePath));
        Files.delete(filePath);
    }

    @Test
    public void testInvalidFolderPath() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String url = "https://example.com/document.pdf";
        String folderPath = "invalid/path";

        DocumentDownloader.main(new String[]{url, folderPath});

        String expectedOutput = "Ошибка: Указанная папка не существует или не является директорией.\n";
        assertEquals(expectedOutput, outputStream.toString().replaceAll("\\r\\n", "\n"));
    }

    @Test
    public void testInvalidArguments() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        DocumentDownloader.main(new String[]{});

        String expectedOutput = "Ошибка: Необходимо указать URL и путь к папке для сохранения файла.\n";
        assertEquals(expectedOutput, outputStream.toString().replaceAll("\\r\\n", "\n"));
    }

    @Test
    public void testInvalidUrl() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String url = "invalid-url";
        String folderPath = "path/to/folder";

        DocumentDownloader.main(new String[]{url, folderPath});

        String expectedOutput = "Ошибка при загрузке документа: no protocol: invalid-url\n";
        assertEquals(expectedOutput, outputStream.toString().replaceAll("\\r\\n", "\n"));
    }

    private boolean fileExists(String filePath) {
        return Files.exists(Path.of(filePath));
    }
}