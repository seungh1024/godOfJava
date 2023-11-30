package com.seungh1024.io;

import java.io.File;
import java.nio.file.Paths;

public class FileFilterSample {
    public static void main(String[] args) {
        FileFilterSample sample = new FileFilterSample();
        String pathName = Paths.get("").toAbsolutePath() + File.separator + "text";
        sample.checkList(pathName);
    }

    private void checkList(String pathName) {
        File file;
        try {
            file = new File(pathName);
//            File[] mainFileList = file.listFiles();
//            File[] mainFileList = file.listFiles(new JPGFileNameFilter());
            File[] mainFileList = file.listFiles(new JPGFileFilter());
            for (File tempFile : mainFileList) {
                System.out.println(tempFile.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
