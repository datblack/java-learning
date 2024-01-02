package datmt.learning.concurency.program12_1;

import java.util.Arrays;

public class Bank {
    private final double[] accounts;

    public Bank(int n, double initialBalance) { // khởi tạo bank với list có n phần tử , mỗi phần tử có giá trị = balance
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    public synchronized void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) return;
        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d ", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
    }

    private double getTotalBalance() {
        return Arrays.stream(accounts).sum();
    }

    public int size() {
        return accounts.length;
    }
}
