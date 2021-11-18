package com.example.libraryApi.models;

import lombok.*;

import java.util.List;

@Data
public class BookModel {
    private String bookId;
    private String bookName;
    private Integer availableQuantity;
    private AuthorModel mainAuthor;
    private List<AuthorModel> coAuthors;
    private List<BorrowerModel> borrowers;
    private BookLocationModel bookLocation;
}
