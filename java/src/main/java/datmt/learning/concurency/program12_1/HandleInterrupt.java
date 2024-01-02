package datmt.learning.concurency.program12_1;

public class HandleInterrupt extends Thread {
    public static Boolean restoreTheState() {
        HandleInterrupt thread1 = new HandleInterrupt();
        thread1.start();
        thread1.interrupt();
        return thread1.isInterrupted();
    }
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  //set the flag back to true
        }
    }

    public static void main(String[] args) {
        System.out.println(HandleInterrupt.restoreTheState());
    }
}
