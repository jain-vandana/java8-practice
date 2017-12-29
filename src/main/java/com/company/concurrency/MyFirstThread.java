package com.company.concurrency;

import java.util.concurrent.TimeUnit;

public class MyFirstThread {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0;i<10;i++){
        System.out.println("Inside main");

    }}

}


class Task implements Runnable{
    @Override
    public void run() {

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    System.out.println("Inside Run");
        go();
    }

    private void go(){
        System.out.println("Inside go");
        more();
    }

    private void more(){
        System.out.println("Inside more");
    }
}
