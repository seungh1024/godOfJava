package com.seungh1024.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapSample {
    public static void main(String[] args) {
        TreeMapSample sample = new TreeMapSample();
        sample.checkTreeMap();
    }

    private void checkTreeMap() {
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("A","a");
        map.put("가","e");
        map.put("1","f");
        map.put("a","g");

        Set<Map.Entry<String,String>> entries = map.entrySet();
        for(Map.Entry<String,String> tempEntry : entries){
            System.out.println(tempEntry.getKey() + "="+tempEntry.getValue());
        }

        TreeMap<Test, Integer> testMap = new TreeMap<>();
//        HashMap<Test, Integer> testMap = new HashMap<>();
        testMap.put(new Test(4),3);
        testMap.put(new Test(3),3);
        testMap.put(new Test(2),2);
        testMap.put(new Test(1),1);

        Set<Map.Entry<Test,Integer>> testEntry = testMap.entrySet();
        for(Map.Entry<Test,Integer> testData : testEntry){
            System.out.println(testData.getKey() + "=" + testData.getValue());
        }

    }

    public static class Test implements Comparable<Test>{
        int x;

        public Test(int x){
            this.x = x;
        }

        @Override
        public int compareTo(Test t){
            return this.x-t.x;
        }

        @Override
        public String toString(){
            return "x: "+x;
        }
    }
}
