package com.seungh1024.thread.practice;

import java.util.Date;

public class TimerThread extends Thread {
    @Override
    public void run(){
        printCurrentTime();
    }

    public void printCurrentTime() {
        try {
            for (int i = 0; i < 10; i++) {
                long mili = System.currentTimeMillis();
                Date date = new Date(mili);
                System.out.println("date: " + date.toString());
                System.out.println("timeMillis: " + (mili - mili%1000) );
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
