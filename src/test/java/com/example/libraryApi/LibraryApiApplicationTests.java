package com.example.libraryApi;

import com.example.libraryApi.books.BookService;
import com.example.libraryApi.books.BookServiceImpl;
import com.example.libraryApi.books.bookContracts.AvailableBookResponse;
import com.example.libraryApi.books.bookContracts.BookResponse;
import com.example.libraryApi.books.bookContracts.FindBookRequest;
import com.example.libraryApi.books.bookContracts.UnavailableBookResponse;
import com.example.libraryApi.common.MockDB;
import com.example.libraryApi.common.rest_controllers.BookRestController;
import com.example.libraryApi.models.BookModel;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LibraryApiApplicationTests {

	@InjectMocks
	private BookServiceImpl bookService;


	@Test
	public void testHomeController() {

		BookRestController bookController = new BookRestController(bookService);

		String result = bookController.home();
		assertEquals(result, "Hello There!, try a GET request on this route to get started: /swagger-ui");

	}

	@Test
	public void testForResponseWhenBookIsUnavailable() {
		BookRestController bookController = new BookRestController(bookService);

		FindBookRequest findBookRequest = new FindBookRequest();
		findBookRequest.setBookName("TestBook");
		ResponseEntity<BookResponse<?>> result1 = bookController.findBookByName(findBookRequest);

		UnavailableBookResponse unAvR = (UnavailableBookResponse) result1.getBody().getData();
		assertEquals("TestBook", unAvR.getBookName());
	}

}
