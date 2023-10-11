package org.example.level3;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DocumentDownloader {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Ошибка: Необходимо указать URL и путь к папке для сохранения файла.");
            return;
        }

        String url = args[0];
        String folderPath = args[1];

        try {
            URL documentUrl = new URL(url);
            String fileName = getFileNameFromUrl(url);
            String filePath = folderPath + File.separator + fileName;

            File folder = new File(folderPath);
            if (!folder.exists() || !folder.isDirectory()) {
                System.out.println("Ошибка: Указанная папка не существует или не является директорией.");
                return;
            }

            Path destination = Path.of(filePath);
            InputStream inputStream = documentUrl.openStream();
            Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Документ успешно сохранен.");
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке документа: " + e.getMessage());
        }
    }

    private static String getFileNameFromUrl(String url) {
        String[] parts = url.split("/");
        return parts[parts.length - 1];
    }
}
