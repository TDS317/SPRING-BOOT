package com.example.HomeWork1_TransactionSpring.service;

import com.example.HomeWork1_TransactionSpring.entity.Computer;
import com.example.HomeWork1_TransactionSpring.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ComputerService {

    @Autowired
    private ComputerRepository repo;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void readCommitted(String name) {
        System.out.println("First read (READ_COMMITTED)");
        Optional<Computer> computer = repo.findByName(name);
        computer.ifPresent(System.out::println);

        sleep(); // Simulate concurrent modification

        System.out.println(" Second read (READ_COMMITTED)");
        computer = repo.findByName(name);
        computer.ifPresent(System.out::println);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void repeatableRead(String name) {
        System.out.println(" First read (REPEATABLE_READ)");
        Optional<Computer> computer = repo.findByName(name);
        computer.ifPresent(System.out::println);

        sleep(); // Simulate concurrent modification

        System.out.println(" Second read (REPEATABLE_READ)");
        computer = repo.findByName(name);
        computer.ifPresent(System.out::println);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void serializableUpdate(String name, int stock) {
        System.out.println(" Serializable update started");
        Optional<Computer> computerOpt = repo.findByName(name);
        computerOpt.ifPresent(computer -> {
            computer.setStock(computer.getStock() + stock);
            repo.save(computer);
            System.out.println(" Stock updated for: " + name);
        });
    }

    private void sleep() {
        try {
            Thread.sleep(10000); // 10 seconds pause
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
