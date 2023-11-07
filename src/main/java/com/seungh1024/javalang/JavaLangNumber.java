package com.seungh1024.javalang;

import java.math.BigInteger;
import java.util.Map;

public class JavaLangNumber {
    public static void main(String[] args) {
        JavaLangNumber sample = new JavaLangNumber();
        sample.numberTypeCheck();
        sample.toBinaryCheck();
        sample.systemPropertiesCheck();
        sample.numberMinMaxElapsedCheck();
    }

    /**
     * parse~~() 메소드 -> 기본 자료형
     * valueOf() 메소드 -> 참조 자료형
     * wrapper클래스는 참조 자료형이지만 기본 자료형처럼 숫자 계산이 됨
     * 이렇게 혼동스럽게 숫자 처리 방법을 만든 이유는
     *  - 매개 변수를 참조 자료형으로만 받는 메소드를 처리하기 위해
     *  - 제네릭 같이 참조 자료형만 사용하는 기능을 사용하기 위해
     *  - 클래스에 선언된 상수 값을 사용하기 위해 (MIN_VALUE 같은 것들)
     *  - 문자열을 숫자로, 숫자를 문자열로 쉽게 변환하기 위해( parse~~ 메소드 제공해서 쉽게 변환이 가능함)
     */
    public void numberTypeCheck() {
        String value1 = "3";
        String value2 = "5";
        byte byte1 = Byte.parseByte(value1);
        byte byte2 = Byte.parseByte(value2);
        System.out.println(byte1+byte2);

        Integer refInt1 = Integer.valueOf(value1);
        Integer refInt2 = Integer.valueOf(value2);
        System.out.println(refInt1 + refInt2 + "7");
    }

    public void toBinaryCheck() {
        int minValue = Integer.MIN_VALUE;
        int maxValue = Integer.MAX_VALUE;

        System.out.println("minValue to Binary = " + Integer.toBinaryString(minValue));
        System.out.println("maxValue to Binary = " + Integer.toBinaryString(maxValue));
    }

    public void systemPropertiesCheck() {
        System.out.println("============= systemPropertiesCheck start================");
        System.out.println("java.version = " + System.getProperty("java.version"));
        System.out.println("JAVA_HOME = " + System.getenv("JAVA_HOME"));
        Map<String, String>map = System.getenv();
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println("key: "+entry.getKey() + ", value : "+ entry.getValue());
        }
        System.out.println("================== end =====================");
    }

    public void numberMinMaxElapsedCheck() {
        JavaLangNumber numberSample = new JavaLangNumber();
        long startTIme = System.currentTimeMillis();
        long startNanoTime = System.nanoTime();
        numberSample.numberMinMaxCheck();
        System.out.println("Milli second = " + (System.currentTimeMillis() - startTIme));
        System.out.println("Nano second = " + (System.nanoTime() - startNanoTime));
    }

    private void numberMinMaxCheck() {
        System.out.println("Byte min = " + Byte.MIN_VALUE + ", max = " + Byte.MAX_VALUE);
        System.out.println("Short min = " + Short.MIN_VALUE + ", max = " + Short.MAX_VALUE);
        System.out.println("Float min = " +Float.MIN_VALUE + ", max = " + Float.MAX_VALUE);
        System.out.println("Character min = " + (int)Character.MIN_VALUE +", max = " + (int)Character.MAX_VALUE);
    }

}
