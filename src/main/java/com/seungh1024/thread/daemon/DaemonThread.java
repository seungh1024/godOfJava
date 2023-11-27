package com.seungh1024.thread.daemon;

public class DaemonThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
