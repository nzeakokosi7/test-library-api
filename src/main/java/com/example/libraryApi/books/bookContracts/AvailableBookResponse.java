package com.example.libraryApi.books.bookContracts;

import com.example.libraryApi.models.AuthorModel;
import com.example.libraryApi.models.BookLocationModel;
import com.example.libraryApi.models.BookModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.awt.print.Book;
import java.util.List;

@Data
public class AvailableBookResponse {
    private String bookName;
    private Integer availableQuantity;
    private AuthorModel mainAuthor;
    private List<AuthorModel> coAuthors;
    private BookLocationModel bookLocation;

    public static AvailableBookResponse getAvailableResponse(BookModel bookModel) {
        AvailableBookResponse avR = new AvailableBookResponse();
        avR.setBookName(bookModel.getBookName());
        avR.setAvailableQuantity(bookModel.getAvailableQuantity());
        avR.setMainAuthor(bookModel.getMainAuthor());
        avR.setCoAuthors(bookModel.getCoAuthors());
        avR.setBookLocation(bookModel.getBookLocation());
        return avR;
    }
}
