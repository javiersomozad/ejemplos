package es.anaya.spring.testing.s07.mockito;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BugRepository extends CrudRepository<Bug, Long> {
	List<Bug> findByTitle(String title);
}
