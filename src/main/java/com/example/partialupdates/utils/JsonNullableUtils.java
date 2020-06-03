package com.example.partialupdates.utils;

import org.openapitools.jackson.nullable.JsonNullable;

import java.util.function.Consumer;

public final class JsonNullableUtils {
    private JsonNullableUtils() {}

    public static <T> void changeIfPresent(JsonNullable<T> nullable, Consumer<T> consumer) {
        if (nullable.isPresent()) {
            consumer.accept(nullable.get());
        }
    }
}
