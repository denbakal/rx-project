package ua.demo.reactive.rx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ua.demo.reactive.rx.entity.Person;
import ua.demo.reactive.rx.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    @PostMapping
    public Mono<Person> post(@RequestBody Person person) {
        return this.personRepository.save(person);
    }

    @GetMapping
    public Flux<Person> get() {
        return this.personRepository.findAll();
    }
}
