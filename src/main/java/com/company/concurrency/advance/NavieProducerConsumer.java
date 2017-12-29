package com.company.concurrency.advance;

import static java.lang.System.exit;

public class NavieProducerConsumer {
    static int count,p_count,c_count;

    public static class Producer implements Runnable{
        @Override
        public void run() {
            while (p_count < 50){
                p_count = count++;
            System.out.println("produce" + p_count);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class Consumer implements Runnable{
        @Override
        public void run() {
            while(true) {
                if(c_count<p_count) {
                    System.out.println("consume" + (c_count++));
                }else{
                    if (c_count==50)
                        break;
                    System.out.println("waiting for producer thread");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }
}
