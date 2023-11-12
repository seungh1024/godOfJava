package com.seungh1024.collection.map;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomNumberStatistics {
    private final int DATA_BOUNDARY = 50;
    private final Hashtable<Integer,Integer> hashtable = new Hashtable<>();
    public static void main(String[] args) {
        RandomNumberStatistics test = new RandomNumberStatistics();
        test.getRandomNumberStatistics();
    }

    public void getRandomNumberStatistics(){
        Random random = new Random();
        for(int i = 0; i < 5000; i++){
            int number = random.nextInt(1,51);
            putCurrentNumber(number);
        }
        printStatistics();
    }

    private void putCurrentNumber(int number) {
        if(!hashtable.containsKey(number)){
            hashtable.put(number,1);
        }else{
            hashtable.put(number,hashtable.get(number)+1);
        }
    }

    public void printStatistics(){
        Set<Integer> keySet = hashtable.keySet();
        StringBuilder sb = new StringBuilder();
        for(int key :keySet){
            sb.append(key).append("=").append(hashtable.get(key)).append(" ");
            if(key%10 - 1 == 0){
                System.out.println(sb);
                sb = new StringBuilder();
            }
        }
        System.out.println(sb);
    }


}
