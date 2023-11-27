package es.anaya.spring.web.s04.restapiswagger.mappings;

import org.springframework.stereotype.Component;

import es.anaya.spring.web.s04.restapiswagger.domain.Author;
import es.anaya.spring.web.s04.restapiswagger.dto.AuthorDTO;

@Component
public class AuthorToAuthorDTOMapper {

	public AuthorDTO authorToAuthorDTO (Author author) {
		if (null == author ) { return null; }
		
		return new AuthorDTO(author.getId(), author.getName());
	}
	
	public Author authorDTOToAuthor (AuthorDTO authorDTO) {
		if (null == authorDTO ) { return null; }
		
		return new Author(authorDTO.getId(), authorDTO.getName());
	}
}
