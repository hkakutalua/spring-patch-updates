package com.example.partialupdates.controllers.dtos;

import org.openapitools.jackson.nullable.JsonNullable;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@SuppressWarnings("FieldMayBeFinal")
public class PersonUpdateDto {
    @NotNull
    private JsonNullable<String> firstName = JsonNullable.undefined();
    @NotNull
    private JsonNullable<String> lastName = JsonNullable.undefined();
    @NotNull
    private JsonNullable<OffsetDateTime> birthday = JsonNullable.undefined();
    private JsonNullable<String> bio = JsonNullable.undefined();
    private JsonNullable<String> imageUrl = JsonNullable.undefined();

    protected PersonUpdateDto() { }

    public JsonNullable<String> getFirstName() {
        return firstName;
    }

    public JsonNullable<String> getLastName() {
        return lastName;
    }

    public JsonNullable<OffsetDateTime> getBirthday() {
        return birthday;
    }

    public JsonNullable<String> getBio() {
        return bio;
    }

    public JsonNullable<String> getImageUrl() {
        return imageUrl;
    }
}
