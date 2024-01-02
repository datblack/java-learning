package datmt.learning.concurency.program12_1;

public class DemonThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = threadNew();
        thread.setDaemon(true);
        System.out.println("Start Main!");
        thread.start();
        Thread.sleep(1000);
        System.out.println("End Main!");
    }

    public static Thread threadNew() {
        return new Thread(() -> {
            while (true){
                try {
                    System.out.println("Thread running !");
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
