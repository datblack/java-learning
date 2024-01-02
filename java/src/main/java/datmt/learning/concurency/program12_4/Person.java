package datmt.learning.concurency.program12_4;

import java.util.concurrent.locks.ReentrantLock;

public class Person {

//    private ReentrantLock personLock = new ReentrantLock();
    private String name;
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Person(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public synchronized void setPrice(Integer price) {
        //TODO: Lock Object
//        personLock.lock();
        try {
            if (price > 10) wait();
            this.price += price;
            System.out.println(Thread.currentThread().getName() + " : " + this.price);
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
//            personLock.unlock();
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
