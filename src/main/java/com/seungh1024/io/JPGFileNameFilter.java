package com.seungh1024.io;

import java.io.File;
import java.io.FilenameFilter;

public class JPGFileNameFilter implements FilenameFilter {

    @Override
    public boolean accept(File file, String fileName) {
        System.out.println(file.isFile());
        if(file.isFile()) System.out.println("i'm file");
        if(fileName.endsWith(".jpeg")) return true;
        return false;
    }
}
