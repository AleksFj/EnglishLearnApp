package main.program.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileScanner {
    //эта функция сканирует все папки по указанному пути и возвращает все найденные файлы
    public static List<File> scanFolder(String folderPath, String fileExtension) {
        List<File> fileList = new ArrayList<>();
        File folder = new File(folderPath);

        if(!fileExtension.startsWith(".")) {
            fileExtension = "." + fileExtension;
        }

        if(folder.isDirectory() && folder.exists()) {
            //System.out.println("Scanning folder: " + folder);
            File[] files = folder.listFiles();
            if(files != null) {
                for(File file : files) {
                    if(file.isFile() && file.getName().toLowerCase().endsWith(fileExtension.toLowerCase())) {
                        fileList.add(file);
                    } else {
                        //поиск файлов в подпапках и добавление их в список
                        fileList.addAll(scanFolder(file.getPath(), fileExtension));
                    }
                }
            }
        }

        return fileList;
    }
}
