package es.anaya.spring.testing.s07.mockmodelservice;

import java.util.List;
import java.util.Optional;

public interface BookService {
	public Optional<Book> getById(Long id);
	public List<Book> getBooks();
}
