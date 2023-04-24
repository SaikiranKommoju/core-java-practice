package com.vsks.thread.deadlock;

public class ThreadA extends Thread {

    private SharedResource sharedResource1;
    private SharedResource sharedResource2;

    public ThreadA(SharedResource sharedResource1, SharedResource sharedResource2) {
        this.sharedResource1 = sharedResource1;
        this.sharedResource2 = sharedResource2;
    }

    @Override
    public void run() {
        System.out.println("Thread-A performing operation on " + sharedResource1 +  " ...");
        sharedResource1.operate1(sharedResource2);
    }
}
