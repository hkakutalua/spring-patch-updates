package com.example.partialupdates.controllers;

import com.example.partialupdates.controllers.dtos.PersonReadDto;
import com.example.partialupdates.controllers.dtos.PersonUpdateDto;
import com.example.partialupdates.domain.Person;
import com.example.partialupdates.repositories.PeopleRepository;
import com.example.partialupdates.utils.JsonNullableUtils;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/people")
public class PeopleController {
    private final PeopleRepository peopleRepository;

    public PeopleController(PeopleRepository peopleRepository) {
        if (peopleRepository == null)
            throw new IllegalArgumentException("peopleRepository can't be null");

        this.peopleRepository = peopleRepository;
    }

    @GetMapping
    public ResponseEntity<List<PersonReadDto>> getAllPeople() {
        List<Person> people = peopleRepository.getAll();
        List<PersonReadDto> personReadDtos = people.stream()
                .map(p -> new PersonReadDto(
                        p.getId(),
                        p.getFirstName(),
                        p.getLastName(),
                        p.getBirthday(),
                        p.getBio().orElse(null),
                        p.getImageUrl().orElse(null)))
                .collect(Collectors.toList());

        return ResponseEntity.ok(personReadDtos);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable("id") long id,
                                             @Valid @RequestBody PersonUpdateDto personUpdateDto) {
        Optional<Person> personOptional = peopleRepository.getById(id);
        if (!personOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Person person = personOptional.get();
        JsonNullableUtils.changeIfPresent(personUpdateDto.getFirstName(), person::setFirstName);
        JsonNullableUtils.changeIfPresent(personUpdateDto.getLastName(), person::setLastName);
        JsonNullableUtils.changeIfPresent(personUpdateDto.getBirthday(), person::setBirthday);
        JsonNullableUtils.changeIfPresent(personUpdateDto.getBio(), person::setBio);
        JsonNullableUtils.changeIfPresent(personUpdateDto.getImageUrl(), person::setImageUrl);

        peopleRepository.save(person);

        return ResponseEntity.noContent().build();
    }
}
