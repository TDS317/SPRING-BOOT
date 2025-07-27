package SpringBootAnnotation.example.Annotation.controller;


import SpringBootAnnotation.example.Annotation.entity.Person;
import SpringBootAnnotation.example.Annotation.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping
    public List<Person> all() {
        return service.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return service.save(person);
    }
}
