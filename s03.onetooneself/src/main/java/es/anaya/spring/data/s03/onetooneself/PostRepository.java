package es.anaya.spring.data.s03.onetooneself;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
	List<Post> findByTitle(String title);
}
