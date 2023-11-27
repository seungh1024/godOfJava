package com.seungh1024.thread.daemon;

public class DaemonThreadTest {
    public static void main(String[] args) {
        DaemonThreadTest test = new DaemonThreadTest();
//        test.runCommonThread();
        test.runDaemonThread();
    }

    private void runCommonThread() {
        DaemonThread thread = new DaemonThread();
        thread.start();
    }

    private void runDaemonThread() {
        DaemonThread thread = new DaemonThread();
        thread.setDaemon(true);
        thread.start();
    }

}
