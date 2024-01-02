package datmt.learning.concurency.program12_1;

public class InterruptExample {
    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                System.out.println("======Trước khi Block=======");
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println("======Sau khi Block=======");
                Thread.sleep(1000);// Thread bị block
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
        Thread thread = new Thread(r);
        thread.setName("test Interrupt");
        thread.interrupt();
        thread.start();

    }
}
