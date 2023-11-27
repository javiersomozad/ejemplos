package es.anaya.spring.testing.s07.mockmodelservice;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;
	
	public BookServiceImpl (BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public Optional<Book> getById(Long id) {
		return bookRepository.findById(id);
	}
	
	@Override
	public List<Book> getBooks() {
		return (List<Book>)bookRepository.findAll();
	}

}
