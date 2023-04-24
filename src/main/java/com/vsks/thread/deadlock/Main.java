package com.vsks.thread.deadlock;

public class Main {

    public static void main(String[] args) {
        SharedResource sharedResource1 = new SharedResource("Shared_Resource-I");
        SharedResource sharedResource2 = new SharedResource("Shared_Resource-II");

        ThreadA threadA = new ThreadA(sharedResource1, sharedResource2);
        ThreadB threadB = new ThreadB(sharedResource1, sharedResource2);

        System.out.println("Starting Thread-A");
        threadA.start();

        System.out.println("Starting Thread-B");
        threadB.start();
    }
}
