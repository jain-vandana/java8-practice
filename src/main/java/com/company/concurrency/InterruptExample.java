package com.company.concurrency;

import java.util.concurrent.TimeUnit;

public class InterruptExample {
    public static void main(String[] args) {
        Thread myThread = new Thread(new InterruptedThread());
        myThread.start();
        try {
            TimeUnit.SECONDS.sleep(3);
            myThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("args = main finished");
    }
}

class InterruptedThread implements Runnable{
    @Override
    public void run() {
        System.out.println("inside run");
        try {
            TimeUnit.SECONDS.sleep(9);
        } catch (InterruptedException e) {
           // e.printStackTrace();
            System.out.println("Thread Interrupted!!");
        }
        go();
    }
    void go(){
        System.out.println("inside go");
        more();
    }

    void more(){
        System.out.println("inside more");
    }
}