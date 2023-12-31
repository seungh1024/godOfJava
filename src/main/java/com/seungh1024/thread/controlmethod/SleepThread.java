package com.seungh1024.thread.controlmethod;

public class SleepThread extends Thread {
    long sleepTime;
    public SleepThread(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            System.out.println("Sleeping " + getName());
            Thread.sleep(sleepTime);
            System.out.println("Stopping " + getName());
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
