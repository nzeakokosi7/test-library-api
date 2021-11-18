package com.example.libraryApi.models;

import lombok.Getter;

import java.util.Random;

@Getter
public enum Shelf {
    FIRST_Shelf,
    SECOND_Shelf,
    THIRD_Shelf,
    FOURTH_Shelf,
    FIFTH_Shelf;

    public static Shelf getRandomShelf() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
