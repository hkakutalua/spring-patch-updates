package com.example.partialupdates.repositories;

import com.example.partialupdates.domain.Person;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.function.UnaryOperator;

@Repository
public class PeopleRepository {
    private static final ArrayList<Person> people = new ArrayList<>();

    public PeopleRepository() {
        Person person1 = new Person(
                1, "Henrick", "Kakutalua", OffsetDateTime.now(),
                "Lorem ipsum", "https://image/profile_photo.jpg");
        Person person2 = new Person(
                2, "Alexandre", "Juca", OffsetDateTime.now(),
                "Lorem ipsum", "https://image/profile_photo.jpg");
        Person person3 = new Person(
                3, "Pedro", "Massango", OffsetDateTime.now(),
                "Lorem ipsum", "https://image/profile_photo.jpg");
        Person person4 = new Person(
                4, "Ilton", "Ingui", OffsetDateTime.now(),
                "Lorem ipsum", "https://image/profile_photo.jpg");
        Person person5 = new Person(
                5, "Aristoteles", "Lopes", OffsetDateTime.now(),
                "Lorem ipsum", "https://image/profile_photo.jpg");

        people.addAll(Arrays.asList(person1, person2, person3, person4, person5));
    }

    public List<Person> getAll() {
        return Collections.unmodifiableList(people);
    }

    public Optional<Person> getById(long id) {
        return people.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    public void save(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("person can't be null");
        }

        if (!people.contains(person)) {
            throw new RuntimeException(String.format("Person with id '%s' does not exists", person.getId()));
        }

        int indexOfPerson = people.indexOf(person);
        people.remove(person);
        people.add(indexOfPerson, person);
    }
}
