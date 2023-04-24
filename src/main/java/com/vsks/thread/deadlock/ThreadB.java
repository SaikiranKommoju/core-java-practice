package com.vsks.thread.deadlock;

public class ThreadB extends Thread {

    private SharedResource sharedResource1;
    private SharedResource sharedResource2;

    public ThreadB(SharedResource sharedResource1, SharedResource sharedResource2) {
        this.sharedResource1 = sharedResource1;
        this.sharedResource2 = sharedResource2;
    }

    @Override
    public void run() {
        System.out.println("Thread-B performing operation on " + sharedResource2 +  " ...");
        sharedResource2.operate1(sharedResource1);
    }
}
