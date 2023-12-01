package com.seungh1024.io.practice;

import java.io.File;
import java.nio.file.Paths;
import java.text.DecimalFormat;

import static java.io.File.separator;

public class FileSizeSummary {
    public static void main(String[] args) {
        FileSizeSummary sample = new FileSizeSummary();
        String path = Paths.get("").toAbsolutePath() + separator +"text";
        long sum = sample.printFileSize(path);
        System.out.println(path + "'s total size = " +sum);
    }

    public long printFileSize(String path) {
        File dir = new File(path);
        long sum = 0;
        if(dir.isDirectory()){
            File[] fileList = dir.listFiles();
            for(File file : fileList){
                if (file.isFile()) {
                    String tempFileName = file.getAbsolutePath();
                    long fileLength = file.length();
                    System.out.println(tempFileName + " = " + convertFileLength(fileLength));
                    sum += fileLength;
                } else {
                    String tempDirName = file.getAbsolutePath();
                    long fileLength = printFileSize(tempDirName);
                    System.out.println("[" + tempDirName + "]= " + convertFileLength(fileLength));
                    sum += fileLength;
                }
            }
        }
        return sum;
    }

    private final long KB = 1024;
    private final long MB = 1024*1024;
    private final long GB = 1024*1024*1024;
    private String convertFileLength(long fileLength) {
        double length = fileLength*1.0;
        String format = "#.##";
        DecimalFormat df = new DecimalFormat(format);
        StringBuilder sb = new StringBuilder("크기");
        if(fileLength <= KB){
            sb.append(df.format(length)).append(" b");
        } else if (fileLength <= MB) {
            length /= KB;
            sb.append(df.format(length)).append(" kb");
        } else if (fileLength <= GB) {
            length /= (MB);
            sb.append(df.format(length)).append(" mb");
        } else {
            length /= (GB);
            sb.append(df.format(length)).append(" gb");
        }
        return sb.toString();
    }
}
