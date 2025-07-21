package com.example.HomeWork1_PropagationSpring.service;

import com.example.HomeWork1_PropagationSpring.entity.Computer;
import com.example.HomeWork1_PropagationSpring.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InnerService {
    @Autowired
    ComputerRepository computerRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void required() {
        computerRepository.save(new Computer(null, "Inner REQUIRED"));
        throw new RuntimeException("Exception in REQUIRED");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void requiresNew() {
        computerRepository.save(new Computer(null, "Inner REQUIRES_NEW"));
        throw new RuntimeException("Exception in REQUIRES_NEW");
    }

    @Transactional(propagation = Propagation.NESTED)
    public void nested() {
        computerRepository.save(new Computer(null, "Inner NESTED"));
        throw new RuntimeException("Exception in NESTED");
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void supports() {
        computerRepository.save(new Computer(null, "Inner SUPPORTS"));
        throw new RuntimeException("Exception in SUPPORTS");
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void notSupported() {
        computerRepository.save(new Computer(null, "Inner NOT_SUPPORTED"));
        throw new RuntimeException("Exception in NOT_SUPPORTED");
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void mandatory() {
        computerRepository.save(new Computer(null, "Inner MANDATORY"));
        throw new RuntimeException("Exception in MANDATORY");
    }

    @Transactional(propagation = Propagation.NEVER)
    public void never() {
        computerRepository.save(new Computer(null, "Inner NEVER"));
        throw new RuntimeException("Exception in NEVER");
    }
}