package com.example.HomeWork1_TransactionSpring.controller;

import com.example.HomeWork1_TransactionSpring.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/computer")
public class ComputerController {

    @Autowired
    private ComputerService service;

    @GetMapping("/read-committed")
    public ResponseEntity<String> readCommitted(@RequestParam String name) {
        service.readCommitted(name);
        return ResponseEntity.ok("Read Committed executed");
    }

    @GetMapping("/repeatable-read")
    public ResponseEntity<String> repeatableRead(@RequestParam String name) {
        service.repeatableRead(name);
        return ResponseEntity.ok("Repeatable Read executed");
    }

    @PostMapping("/serializable")
    public ResponseEntity<String> serializable(@RequestParam String name, @RequestParam int stock) {
        service.serializableUpdate(name, stock);
        return ResponseEntity.ok("Serializable update executed");
    }
}
