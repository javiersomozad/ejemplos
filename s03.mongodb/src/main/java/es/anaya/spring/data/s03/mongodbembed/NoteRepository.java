package es.anaya.spring.data.s03.mongodbembed;

import java.util.Date;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, Integer> {
	Note findByText(String text);
    Note findByDate(Date date);
}