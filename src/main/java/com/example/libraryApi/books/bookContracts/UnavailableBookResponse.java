package com.example.libraryApi.books.bookContracts;

import com.example.libraryApi.models.AuthorModel;
import com.example.libraryApi.models.BookModel;
import com.example.libraryApi.models.BorrowerModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UnavailableBookResponse {
    private String bookName;
    private List<BorrowerModel> borrowers;

    public static UnavailableBookResponse getUnavailableResponse(BookModel bookModel) {
        UnavailableBookResponse unAvR = new UnavailableBookResponse();
        unAvR.setBookName(bookModel.getBookName());
        unAvR.setBorrowers(bookModel.getBorrowers());
        return unAvR;
    }
}
