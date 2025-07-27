package SpringBootAnnotation.example.Annotation.service;

import SpringBootAnnotation.example.Annotation.entity.Person;
import SpringBootAnnotation.example.Annotation.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Transactional
    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person save(Person person) {
        return repository.save(person);
    }
}