package com.example.libraryApi.common.rest_controllers;

import com.example.libraryApi.books.BookService;
import com.example.libraryApi.books.bookContracts.BookResponse;
import com.example.libraryApi.books.bookContracts.FindBookRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BookRestController {

    private final BookService bookService;

    @GetMapping("")
    public String home() {
        return "Hello There!, try a GET request on this route to get started: /swagger-ui/";
    }

    @PostMapping("find-book")
    public ResponseEntity<BookResponse<?>> findBookByName(@RequestBody FindBookRequest request) {
        return  ResponseEntity.ok(bookService.findBookByName(request));
    }

    @GetMapping("all-books")
    public ResponseEntity<BookResponse<?>> getAllBooks() {
        return  ResponseEntity.ok(bookService.getAllBooks());
    }

}
