package com.example.HomeWork1_PropagationSpring.service;

import com.example.HomeWork1_PropagationSpring.entity.Computer;
import com.example.HomeWork1_PropagationSpring.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OuterService {
    @Autowired
    InnerService innerService;

    @Autowired
    ComputerRepository computerRepository;

    @Transactional
    public void call(String type) {
        computerRepository.save(new Computer(null, "Outer Start"));
        try {
            switch (type) {
                case "required" -> innerService.required();
                case "requires_new" -> innerService.requiresNew();
                case "nested" -> innerService.nested();
                case "supports" -> innerService.supports();
                case "not_supported" -> innerService.notSupported();
                case "mandatory" -> innerService.mandatory();
                case "never" -> innerService.never();
                default -> throw new IllegalArgumentException("Unknown type: " + type);
            }
        } catch (Exception e) {
            System.out.println("Caught exception in Outer: " + e.getMessage());
        }
        computerRepository.save(new Computer(null, "Outer End"));
    }

    public List<Computer> list() {
        return computerRepository.findAll();
    }

    public void clear() {
        computerRepository.deleteAll();
    }
}