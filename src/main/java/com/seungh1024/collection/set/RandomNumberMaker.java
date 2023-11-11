package com.seungh1024.collection.set;

import java.util.HashSet;
import java.util.Random;

public class RandomNumberMaker {
    public static void main(String[] args) {
        RandomNumberMaker rm = new RandomNumberMaker();
        for (int i = 0; i < 10; i++) {
            System.out.println(rm.getSixNumber());
        }
    }

    public HashSet<Integer> getSixNumber() {
        Random random = new Random();
        HashSet<Integer> set = new HashSet<>();
        while(set.size() < 6){
            int tempNumber = random.nextInt(45);
            set.add(tempNumber);
        }

        return set;
    }
}
