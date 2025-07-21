package com.example.HomeWork1_TransactionSpring.repository;

import com.example.HomeWork1_TransactionSpring.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {
    Optional<Computer> findByName(String name);
}