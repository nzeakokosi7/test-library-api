package com.example.libraryApi.common;

import com.example.libraryApi.books.bookContracts.FindBookRequest;
import com.example.libraryApi.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockDB {
    private List<BookModel> books;

    private static MockDB instance = null;
    public static MockDB getInstance(){
        if(instance == null){
            instance = new MockDB();
        }
        return instance;
    }

    private MockDB() {
        books = new ArrayList<BookModel>();
        String[] bookNames = {"Edet Goes to School", "Cinderella", "Rich Dad, Poor Dad"};
        String[] authorFirstNames = {"Kosi", "Jerry", "Femi", "Soji"};
        String[] authorLastNames = {"Nzeako", "Kayode", "Bakare", "Nwagba"};

        for (int i=0; i<10; i++){
            int rdBookName = new Random().nextInt(bookNames.length);
            int rdAuthorName = new Random().nextInt(authorFirstNames.length);

            BookLocationModel bookLocationModel = new BookLocationModel();
            bookLocationModel.setAisle(Aisle.getRandomAisle());
            bookLocationModel.setShelf(Shelf.getRandomShelf());
            bookLocationModel.setShelfRow(ShelfRow.getRandomShelfRow());

            AuthorModel author = new AuthorModel();
            author.setFirstName(authorFirstNames[rdAuthorName]);
            author.setLastName(authorLastNames[rdAuthorName]);


            BookModel bookModel = new BookModel();
            bookModel.setBookId(String.valueOf(i));
            bookModel.setBookName(bookNames[rdBookName]);
            bookModel.setAvailableQuantity(i);
            bookModel.setBookLocation(bookLocationModel);
            bookModel.setMainAuthor(author);
            bookModel.setCoAuthors(getRandomCoAuthors(authorFirstNames, authorLastNames));
            bookModel.setBorrowers(getRandomBorrowers());

            books.add(bookModel);
        }

        BookModel bookModel = new BookModel();
        bookModel.setBookId(String.valueOf(99));
        bookModel.setBookName("TestBook");
        bookModel.setAvailableQuantity(0);
        bookModel.setBookLocation(null);
        bookModel.setMainAuthor(null);
        bookModel.setCoAuthors(getRandomCoAuthors(authorFirstNames, authorLastNames));
        bookModel.setBorrowers(getRandomBorrowers());

        books.add(bookModel);
    }

    public BookModel findBookByName(FindBookRequest request) {
        return books.stream().filter(bk -> bk.getBookName().equals(request.getBookName())).findFirst().orElse(null);
    }

    public List<BookModel> getAllBooks() {
        return books;
    }

    private List<AuthorModel> getRandomCoAuthors(String[] authorFirstNames, String[] authorLastNames) {
        List<AuthorModel> coAuthors = new ArrayList<>();
        int rdAuthorName = new Random().nextInt(authorFirstNames.length);

        for(int i=0; i< new Random().nextInt(5); i++) {

            AuthorModel coAuthor = new AuthorModel();
            coAuthor.setFirstName(authorFirstNames[rdAuthorName]);
            coAuthor.setLastName(authorLastNames[rdAuthorName]);

            coAuthors.add(coAuthor);
        }
        return coAuthors;
    }

    private List<BorrowerModel> getRandomBorrowers() {
        List<BorrowerModel> borrowers = new ArrayList<>();
        String[] borrowerNames = {"Benjamin", "Chizzy", "Manny", "Soji"};
        int rdBorrowerName = new Random().nextInt(borrowerNames.length);

        for(int i=1; i< new Random().nextInt(10); i++) {

            BorrowerModel borrower = new BorrowerModel();
            borrower.setBorrowerName(borrowerNames[rdBorrowerName]);
            borrower.setReturnDate(i+"/11/2021");

            borrowers.add(borrower);
        }
        return borrowers;
    }
}
