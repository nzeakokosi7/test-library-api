package com.example.libraryApi.books.bookContracts;

import com.example.libraryApi.models.AuthorModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindBookRequest {
    private String bookName;
}
