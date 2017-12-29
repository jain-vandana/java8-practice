package com.company.concurrency;

public class RaceConditionWithIDGenerator {


    public static void main(String[] args) {
        IDGenrator task = new IDGenrator();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.setName("One");
        t2.setName("Two");
        t1.start();
        t2.start();
    }

}


class IDGenrator implements Runnable{
int id =0;
    @Override
    public void run() {

        while (id<25) {
            System.out.println(Thread.currentThread().getName() + "id is" + id++);
        }
    }


}