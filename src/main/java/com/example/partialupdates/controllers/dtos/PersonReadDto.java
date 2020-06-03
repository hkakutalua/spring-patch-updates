package com.example.partialupdates.controllers.dtos;

import java.time.OffsetDateTime;

public class PersonReadDto {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final OffsetDateTime birthday;
    private final String bio;
    private final String imageUrl;

    public PersonReadDto(long id, String firstName, String lastName, OffsetDateTime birthday, String bio, String imageUrl) {
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

    public String getLastName() {
        return lastName;
    }

    public OffsetDateTime getBirthday() {
        return birthday;
    }

    public String getBio() {
        return bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
