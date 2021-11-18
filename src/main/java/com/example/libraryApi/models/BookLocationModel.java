package com.example.libraryApi.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookLocationModel {
    private Aisle aisle;
    private Shelf shelf;
    private ShelfRow shelfRow;
}
