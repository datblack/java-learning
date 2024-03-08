package com.example.kafkademo.service;

import com.example.kafkademo.entity.Number;
import com.example.kafkademo.entity.NumberRepository;
import com.example.kafkademo.entity.People;
import com.example.kafkademo.entity.PeopleRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ServiceTest {
    @Autowired
    private NumberRepository numberRepository;
    @Autowired
    private PeopleRepository peopleRepository;


    @Transactional
    public void insertNumber() throws Exception {
        numberRepository.save(new Number(null, 1));
        insertPeople();
    }

    @Transactional
    public void insertPeople() throws Exception {
        peopleRepository.save(new People(null, "thế đạt"));
//          throw new Exception();
    }

    @Transactional
    public void testThread() {
        List<People> people = createPeople();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        peopleRepository.saveAll(people);
//        //Code của a lead
//        for (int i = 0; i < 10; i++) {
//            executorService.submit(new ThreadTest(peopleRepository, people));
//        }
        //Code của em đạt nghe theo a hiếu
        Lists.partition(people, 500)
                .forEach(people1 -> executorService.submit(() -> {
                    System.out.println("========People size :" + people1.size());
                    System.out.println(Thread.currentThread().getName());
                    peopleRepository.saveAll(people1);
                }));
        executorService.shutdown();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.currentThread().wait(5000);
                System.out.println("Is shutdown:" + executorService.isShutdown());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private List<People> createPeople() {
        List<People> people = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            people.add(new People(i + 1, generateName()));
        }
        return people;
    }

    private String generateName() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            stringBuilder.append(Character.toChars(ThreadLocalRandom.current().nextInt(97, 122)));
        }
        return stringBuilder.toString();
    }

    public void testError() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<People> people = createPeople();
        executorService.submit(() -> {
            Lists.partition(people, 100).forEach(people2 -> {
                peopleRepository.saveAll(people2);
            });
        });
        executorService.shutdown();
        peopleRepository.saveAll(people);
    }
    private List<Number> createNumbers() {
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(new Number(i + 1, ThreadLocalRandom.current().nextInt(0, 100)));
        }
        return numbers;
    }
}
