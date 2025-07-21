package com.example.HomeWork1_PropagationSpring.controller;

import com.example.HomeWork1_PropagationSpring.entity.Computer;
import com.example.HomeWork1_PropagationSpring.service.OuterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
class ComputerController {
    @Autowired
    OuterService outerService;

    @PostMapping("/demo/{type}")
    public String demo(@PathVariable String type) {
        outerService.clear();
        outerService.call(type);
        return "Done. Check saved computers.";
    }

    @GetMapping("/computers")
    public List<Computer> list() {
        return outerService.list();
    }
}