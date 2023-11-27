
package es.anaya.spring.testing.s07.mockmodelservice;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.anaya.spring.testing.s07.mockmodelservice.Book;
import es.anaya.spring.testing.s07.mockmodelservice.BookRepository;
import es.anaya.spring.testing.s07.mockmodelservice.BookService;
import es.anaya.spring.testing.s07.mockmodelservice.BookServiceImpl;

public class BookServiceImplTest {
	
	private BookService bookService;
	
	@Mock 
	private BookRepository bookRepository;
	
	@Before
	public void setUp () throws Exception {
		MockitoAnnotations.initMocks(this);
		bookService = new BookServiceImpl(bookRepository);
	}
	
	@Test
	public void getBugs () throws Exception {
		
		List<Book> bookData = new ArrayList<Book>();
		bookData.add(new Book());
		bookData.add(new Book());

		when(bookService.getBooks()).thenReturn(bookData);
		List<Book> bugs = bookService.getBooks();
		
		assertEquals(bugs.size(), 2);
		verify(bookRepository, times(1)).findAll();
	}
}
