package com.seungh1024.io.readwrite;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.io.File.separator;

public class ManageTextFile {
    public static void main(String[] args) {
        ManageTextFile manager = new ManageTextFile();
        int numberCount = 10;
        String fullPath = Paths.get("").toAbsolutePath() + separator + "text" + separator + "numbers.txt";
        manager.writeFile(fullPath,numberCount);
        manager.readFile(fullPath);
        manager.readFileWithScanner(fullPath);
    }

    public void writeFile(String fileName, int numberCount) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i <= numberCount; i++) {
                bufferedWriter.write(Integer.toString(i));
                bufferedWriter.newLine();
            }
            System.out.println("Wirte success !!!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }

        }
    }

    public void readFile(String fileName) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String data;
            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }
            System.out.println("Read success !!!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public void readFileWithScanner(String fileName) {
        File file = new File(fileName);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            System.out.println("Read success !!!");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
