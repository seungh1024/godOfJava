package com.seungh1024.javalang;

public class NumberObjects {
    public static void main(String[] args) {
        NumberObjects numberObjects = new NumberObjects();
        long number;
        number = numberObjects.parseLong("r1024");
        System.out.println("number : " +number);
        number = numberObjects.parseLong("1024");
        System.out.println("number : " +number);

        numberObjects.printOtherBase(1024);
    }

    public long parseLong(String data) {
        long returnNumber = -1;
        try {
            returnNumber = Long.parseLong(data);
        } catch (NumberFormatException e) {
            System.out.println(String.valueOf(data) + " is not a number");
        }
        return returnNumber;
    }

    public void printOtherBase(long value) {
        String binary = Long.toBinaryString(value);
        String octal = Long.toOctalString(value);
        String hex = Long.toHexString(value);
        StringBuilder sb = new StringBuilder();
        sb.append("Original : ").append(value).append("\n")
                .append("Binary : ").append(binary).append("\n")
                .append("Hex : ").append(hex).append("\n")
                .append("Octal : ").append(octal).append("\n");
        System.out.println(String.valueOf(sb));
    }
}
