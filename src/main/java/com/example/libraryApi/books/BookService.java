package com.example.libraryApi.books;

import com.example.libraryApi.books.bookContracts.BookResponse;
import com.example.libraryApi.books.bookContracts.FindBookRequest;
import com.example.libraryApi.common.dtos.GenericResponse;
import com.example.libraryApi.models.BookModel;

import java.util.List;

public interface BookService {
    BookResponse<Object> findBookByName(FindBookRequest request);
    BookResponse<List<BookModel>> getAllBooks();
}
