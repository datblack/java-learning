package datmt.learning.funtional_interface.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.random.RandomGenerator;

public class RunnerClass {
    public static void main(String[] args) {
//        var service = new ServiceImpl();
//        service.calculating(i -> (double) (Arrays.stream(i).sum() / i.length), 1,2,3,5,6);// define function by lambda
//        service.calculating(new CalculatorImpl(), 1,2,3,5,6);// function defined by class implement
        List<Integer> integers = new ArrayList<>();
        Runnable runnable = () ->{
            for (int i = 0; i < 99; i++) {
                integers.add(ThreadLocalRandom.current().nextInt());
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        integers.forEach(System.out::println);
    }
}
