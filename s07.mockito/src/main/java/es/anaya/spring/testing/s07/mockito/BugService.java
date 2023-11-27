package es.anaya.spring.testing.s07.mockito;

import java.util.List;
import java.util.Optional;

public interface BugService {
	public Optional<Bug> getById(Long id);
	public List<Bug> getBugs();
}
