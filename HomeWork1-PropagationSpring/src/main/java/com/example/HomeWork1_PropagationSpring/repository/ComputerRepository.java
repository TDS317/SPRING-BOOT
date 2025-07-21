package com.example.HomeWork1_PropagationSpring.repository;

import com.example.HomeWork1_PropagationSpring.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {}