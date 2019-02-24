package ua.demo.reactive.rx.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ua.demo.reactive.rx.entity.Person;

public interface PersonRepository extends ReactiveMongoRepository<Person, Long> {
}
