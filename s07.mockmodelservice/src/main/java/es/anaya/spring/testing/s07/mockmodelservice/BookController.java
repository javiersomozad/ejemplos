package es.anaya.spring.testing.s07.mockmodelservice;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/books")
	public String list(Model model) {
		model.addAttribute("books", bookService.getBooks());
		Optional<Book> book = bookService.getById(1L);
		System.out.println("Show this: " + book);
		return "books";
	}
}
