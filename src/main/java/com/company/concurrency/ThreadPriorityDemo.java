package com.company.concurrency;

public class ThreadPriorityDemo {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread());
        Thread t1 = new Thread(new EmailCampaign());
        Thread t2 = new Thread(new DataAggregator());
        t1.setName("EmailCampaign");
        t2.setName("DataAggregator");
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t2.start();
        t1.start();

        try {
            //main thread is suspended until t2 DIES
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("inside main");
    }
}
class EmailCampaign implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<10;i++){
            System.out.println(Thread.currentThread().getName());
            if(i==5){
                // Hint to scheduler that thread is willing to
                // yield its current use of CPU
                Thread.currentThread().yield();
            }
        }
    }
}

class DataAggregator implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<10;i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}