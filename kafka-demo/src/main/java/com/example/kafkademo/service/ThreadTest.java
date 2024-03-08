package com.example.kafkademo.service;

import com.example.kafkademo.entity.People;
import com.example.kafkademo.entity.PeopleRepository;

import javax.transaction.Transactional;
import java.util.List;

public class ThreadTest implements Runnable {
    private final PeopleRepository peopleRepository;
    private final List<People> people;
    public ThreadTest(PeopleRepository peopleRepository, List<People> people) {
        this.peopleRepository = peopleRepository;
        this.people = people;
    }

    @Override
    public void run() {
        System.out.println("========People size :" + people.size());
        System.out.println(Thread.currentThread().getName());
        peopleRepository.saveAll(people);
    }
}
