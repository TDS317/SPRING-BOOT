package com.example.HomeWork1_BeanLifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class BeanLifeCycle {

    private String connection;

    public BeanLifeCycle() {
        System.out.println("Constructor: BeanLifeCycle created.");
    }

    @PostConstruct
    public void init() {
        // Simulate opening a connection
        this.connection = "Connected to DB";
        System.out.println("PostConstruct: " + connection);
    }

    public void doWork() {
        System.out.println("Working with resource: " + connection);
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("PreDestroy: Closing " + connection);
    }

    public void close() {
        System.out.println("Custom destroy method called: close()");
    }
}