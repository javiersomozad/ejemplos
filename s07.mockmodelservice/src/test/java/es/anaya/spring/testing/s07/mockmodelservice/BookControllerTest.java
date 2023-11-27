package es.anaya.spring.testing.s07.mockmodelservice;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class BookControllerTest {

    @Mock
    BookService bookService;

    @Mock
    Model model;

    BookController bookController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        bookController = new BookController(bookService);
    }

    @Test
    public void testIndexPage() throws Exception {

        String viewName = bookController.list(model);

        assertEquals("books", viewName);
        verify(bookService, times(1)).getBooks();
        verify(model, times(1)).addAttribute(eq("books"), anyList());
    }
    
    @Test
    public void testModelIndexPage() throws Exception {
    	List<Book> books = new ArrayList();

    	books.add(new Book(1L,"a","aa"));
    	books.add(new Book(2L,"b","bb"));    	
    	books.add(new Book(3L,"c","cc"));  	
    	
    	when(bookService.getBooks()).thenReturn(books);
    	ArgumentCaptor<List<Book>> argumentCaptor = ArgumentCaptor.forClass(List.class);
    	
        String viewName = bookController.list(model);

        assertEquals("books", viewName);
        verify(bookService, times(1)).getBooks();
        
        verify(model, times(1)).addAttribute(eq("books"), argumentCaptor.capture());
        
        List<Book> listInsideController = argumentCaptor.getValue();
        assertEquals(3, listInsideController.size());
    }

}