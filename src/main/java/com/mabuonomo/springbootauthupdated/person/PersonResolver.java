package com.mabuonomo.springbootauthupdated.person;

import org.springframework.stereotype.Service;

import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

import java.util.List;
import java.util.Optional;

@Service
public class PersonResolver {

    private final PersonRepository repository;

    // @Autowired
    public PersonResolver(PersonRepository repository) {
        this.repository = repository;
    }

    @GraphQLMutation(name = "savePerson")
    public Person save(@GraphQLArgument(name = "bike") Person person) {
        return repository.save(person);
    }

    @GraphQLQuery(name = "persons")
    public List<Person> doWork() {

        repository.deleteAll();

        Person person = new Person();
        person.setFirstname("Oliver");
        person.setLastname("Gierke");
        person = repository.save(person);

        List<Person> lastNameResults = repository.findByLastname("Gierke");
        List<Person> firstNameResults = repository.findByFirstnameLike("Oli*");

        return lastNameResults;
    }
}