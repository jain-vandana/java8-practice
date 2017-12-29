package com.company.concurrency;

import java.util.concurrent.TimeUnit;

public class StopThreadVolatile {
    private static volatile boolean stop;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            int count=0;
            @Override
            public void run() {
                while (!stop){
                    count++;
                    System.out.println("in while ......"+count);
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        stop = true;
    }
}
