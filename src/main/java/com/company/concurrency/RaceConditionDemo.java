package com.company.concurrency;

public class RaceConditionDemo {

    public static void main(String[] args) {

        BankAccount task = new BankAccount();
        task.setBalance(100);
        Thread vandana = new Thread(task);
        Thread vani = new Thread(task);
        vandana.setName("vandana");
        vani.setName("vani");
        vandana.start();
        vani.start();
    }
}

class BankAccount implements Runnable{
 int balance;
    @Override
    public void run() {
        makeWithdrawal(75);
        if(balance < 0){
            System.out.println("Money overdraw!!!");
        }
    }

    void setBalance(int balance){
        this.balance = balance;
    }

    private void makeWithdrawal(int amount) {
        if (balance >= amount) {
        System.out.println(Thread.currentThread().getName() + " is about to withdraw .. balance");
                balance-= amount;
        System.out.println(Thread.currentThread().getName() + " has withdrawn " + amount);
        } else {
        System.out.println("Sorry, not enough balance for " + Thread.currentThread().getName());
        }
    }
}
