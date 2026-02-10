package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankApp {

    // Shared Resource
    static class BankAccount {
        private int balance = 1000;


        public synchronized void deposit(int amount) {
            balance += amount;
            System.out.println(Thread.currentThread().getName()
                    + " deposited " + amount + " | Balance: " + balance);
        }

        public synchronized void withdraw(int amount) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName()
                        + " withdrew " + amount + " | Balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " tried to withdraw " + amount + " | Insufficient balance");
            }
        }

        public int getBalance() {
            return balance;
        }
    }


    static class TransactionTask implements Runnable {
        private BankAccount account;
        private boolean isDeposit;
        private int amount;

        public TransactionTask(BankAccount account, boolean isDeposit, int amount) {
            this.account = account;
            this.isDeposit = isDeposit;
            this.amount = amount;
        }

        @Override
        public void run() {
            if (isDeposit) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        BankAccount account = new BankAccount();

        
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new TransactionTask(account, true, 500));
        executor.execute(new TransactionTask(account, false, 300));
        executor.execute(new TransactionTask(account, false, 800));
        executor.execute(new TransactionTask(account, true, 200));
        executor.execute(new TransactionTask(account, false, 400));

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("\nFinal Balance: " + account.getBalance());
    }
}
