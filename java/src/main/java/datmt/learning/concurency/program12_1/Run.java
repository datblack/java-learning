package datmt.learning.concurency.program12_1;

public class Run {
    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1000;
    public static void main(String[] args) {
        Bank bank = new Bank( 4, 100000);
        Runnable task1 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(0, 1,amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException ignored) {
            }
        };
        Runnable task2 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(2, 3,amount);
                    Thread.sleep((int) (DELAY * Math.random()));
                }
            } catch (InterruptedException ignored) {
            }
        };
        new Thread(task1).start(); // chạy thread
        new Thread(task2).start(); // chạy thread
    }
}
