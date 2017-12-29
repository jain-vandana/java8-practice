package com.company.concurrency;

public class MyFirstThread2 extends Thread{
    @Override
    public void run() {
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

    public static void main(String[] args) {

        MyFirstThread2 thread = new MyFirstThread2();
        thread.start();
        for (int i=0;i<10;i++){
            System.out.println("Inside main");
            System.out.println("Inside main");
            System.out.println("Inside main");
            System.out.println("Inside main");
        }}
}
