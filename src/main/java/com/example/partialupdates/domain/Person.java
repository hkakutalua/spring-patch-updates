package com.example.partialupdates.domain;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;

public class Person {
    private final long id;
    private String firstName;
    private String lastName;
    private OffsetDateTime birthday;
    private String bio;
    private String imageUrl;

    public Person(long id, String firstName, String lastName, OffsetDateTime birthday, String bio, String imageUrl) {
        if (firstName == null) {
            throw new IllegalArgumentException("firstName can't be null");
        }
        if (lastName == null) {
            throw new IllegalArgumentException("lastName can't be null");
        }
        if (birthday == null) {
            throw new IllegalArgumentException("birthday can't be null");
        }

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.bio = bio;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("firstName can't be null");
        }

        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("lastName can't be null");
        }

        this.lastName = lastName;
        return this;
    }

    public OffsetDateTime getBirthday() {
        return birthday;
    }

    public Person setBirthday(OffsetDateTime birthday) {
        if (birthday == null) {
            throw new IllegalArgumentException("birthday can't be null");
        }

        this.birthday = birthday;
        return this;
    }

    public Optional<String> getBio() {
        return Optional.ofNullable(bio);
    }

    public Person setBio(String bio) {
        this.bio = bio;
        return this;
    }

    public Optional<String> getImageUrl() {
        return Optional.ofNullable(imageUrl);
    }

    public Person setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
