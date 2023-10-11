package org.example.level3;

import java.io.File;

public class FileSearch {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Ошибка: Необходимо указать путь к папке и расширение файла.");
            return;
        }

        String folderPath = args[0];
        String fileExtension = args[1];

        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Ошибка: Указанная папка не существует или не является директорией.");
            return;
        }

        searchFiles(folder, fileExtension);
    }

    public static void searchFiles(File folder, String fileExtension) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchFiles(file, fileExtension);
                } else if (file.getName().endsWith(fileExtension)) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}