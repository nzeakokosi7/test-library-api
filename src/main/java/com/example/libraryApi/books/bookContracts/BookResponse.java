package com.example.libraryApi.books.bookContracts;

import com.example.libraryApi.common.dtos.GenericResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.HashMap;

public class BookResponse<T> extends GenericResponse<T> {
    public BookResponse(T data){
        super(false, "Book(s) found", data);
    }

    public BookResponse(Boolean error, T data){
        super(error, "The Book in question is unavailable", data);
    }

    @SneakyThrows
    @Override
    public String toString(){
        var payload = new HashMap<>();
        payload.put("error", this.isError());
        payload.put("message", this.getMessage());
        payload.put("data", this.getData());

        return new ObjectMapper().writeValueAsString(payload);
    }
}
