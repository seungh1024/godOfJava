package com.seungh1024.thread.practice;

public class TimerMain {
    public static void main(String[] args) {
        TimerThread thread = new TimerThread();
        thread.start();
    }
}
