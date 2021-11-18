package com.example.libraryApi.models;

import lombok.Getter;

import java.util.Random;

@Getter
public enum ShelfRow {
    ROW_ONE,
    ROW_TWO,
    ROW_THREE,
    ROW_FOUR,
    ROW_FIVE;

    public static ShelfRow getRandomShelfRow() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
