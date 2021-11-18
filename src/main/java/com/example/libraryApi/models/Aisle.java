package com.example.libraryApi.models;

import lombok.Getter;

import java.util.Random;

@Getter
public enum Aisle {
    AISLE_ONE,
    AISLE_TWO,
    AISLE_THREE,
    AISLE_FOUR,
    AISLE_FIVE;

    public static Aisle getRandomAisle() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
