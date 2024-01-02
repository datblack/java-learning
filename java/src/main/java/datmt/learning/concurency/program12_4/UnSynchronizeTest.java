package datmt.learning.concurency.program12_4;

public class UnSynchronizeTest {
    public static void main(String[] args) throws InterruptedException {
        Person person = new Person("datmt", 5000);
        Runnable task1 = () -> {
            for (int i = 0; i < 10; i++) {
                person.setPrice(500);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable task2 = () -> {
            for (int i = 0; i < 10; i++) {
                person.setPrice(900);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        new Thread(task1).start();
        new Thread(task2).start();
//        Thread.sleep(2000);
    }
}
