package com.seungh1024.io;

import java.io.File;
import java.io.FileFilter;

public class JPGFileFilter implements FileFilter {

    @Override
    public boolean accept(File file) {
        System.out.println(file.isFile());
        if (file.isFile()) {
            String fileName = file.getName();
            if(fileName.endsWith(".jpeg")) return true;
        }
        return false;
    }
}
