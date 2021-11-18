package com.example.libraryApi.books;

import com.example.libraryApi.books.bookContracts.AvailableBookResponse;
import com.example.libraryApi.books.bookContracts.BookResponse;
import com.example.libraryApi.books.bookContracts.FindBookRequest;
import com.example.libraryApi.books.bookContracts.UnavailableBookResponse;
import com.example.libraryApi.common.MockDB;
import com.example.libraryApi.common.dtos.GenericResponse;
import com.example.libraryApi.common.exceptions.NotFoundException;
import com.example.libraryApi.models.BookModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    MockDB mockDB = MockDB.getInstance();

    @Override
    public BookResponse<Object> findBookByName(FindBookRequest request) {
        BookModel bookModel = mockDB.findBookByName(request);

        if(bookModel !=null){
            if (bookModel.getAvailableQuantity() == 0) {
                return new BookResponse<>(true, UnavailableBookResponse.getUnavailableResponse(bookModel));
            }
            return new BookResponse<>(AvailableBookResponse.getAvailableResponse(bookModel));
        }
        throw new NotFoundException("The book "+request.getBookName() +", doesn't exist in this library.");
    }

    @Override
    public BookResponse<List<BookModel>> getAllBooks() {
        return new BookResponse<>(mockDB.getAllBooks());
    }
}
