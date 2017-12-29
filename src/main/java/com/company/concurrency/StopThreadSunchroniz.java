package com.company.concurrency;

import java.util.concurrent.TimeUnit;

public class StopThreadSunchroniz {
    private static boolean stop;
    private static synchronized void requestStop(){
        stop =true;
    }
    private static synchronized boolean stop(){
        return stop;
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stop()){
                    System.out.println("in side while.....");
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
