package es.anaya.spring.testing.s07.mockito;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class BugServiceImpl implements BugService {

	private BugRepository bugRepository;

	public BugServiceImpl(BugRepository bugRepository) {
		this.bugRepository = bugRepository;
	}

	@Override
	public Optional<Bug> getById(Long id) {
		return bugRepository.findById(id);
	}

	@Override
	public List<Bug> getBugs() {
		return (List<Bug>) bugRepository.findAll();
	}
}
