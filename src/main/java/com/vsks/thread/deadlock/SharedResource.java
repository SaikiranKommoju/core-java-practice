package com.vsks.thread.deadlock;

public class SharedResource {

    private String name;

    public SharedResource(String name) {
        this.name = name;
    }

    public void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void operate1(SharedResource sharedResource) {
        System.out.println("Started performing operation 1 on " + sharedResource + " ...");
        sleep(1000);
        sharedResource.operate2(); // this shared resource is locked by current thread, during the sleep the parameter shared resource is locked by other thread, hence this method call won't be started
        System.out.println("Ended performing operation 1 on " + sharedResource + " ...");
    }

    public synchronized void operate2() {
        System.out.println("Started performing operation 2 on " + this + " ...");
        sleep(1000);
        System.out.println("Ended performing operation 2 on " + this + " ...");
    }

    @Override
    public String toString() {
        return name;
    }
}
