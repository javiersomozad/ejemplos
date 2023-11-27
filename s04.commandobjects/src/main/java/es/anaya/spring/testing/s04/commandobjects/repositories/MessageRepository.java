package es.anaya.spring.testing.s04.commandobjects.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.anaya.spring.testing.s04.commandobjects.domain.Message;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
	List<Message> findByTitle(String title);

}
