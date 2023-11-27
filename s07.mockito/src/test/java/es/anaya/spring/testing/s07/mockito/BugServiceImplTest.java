package es.anaya.spring.testing.s07.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BugServiceImplTest {
	
	private BugService bugService;
	
	@Mock 
	private BugRepository bugRepository;
	
	@Before
	public void setUp () throws Exception {
		MockitoAnnotations.initMocks(this);
		bugService = new BugServiceImpl(bugRepository);
	}
	
	@Test
	public void getBugs () throws Exception {
		
		List<Bug> bugData = new ArrayList<Bug>();
		bugData.add(new Bug());
		bugData.add(new Bug());

		when(bugService.getBugs()).thenReturn(bugData);
		List<Bug> bugs = bugService.getBugs();
		
		assertEquals(bugs.size(), 2);
		verify(bugRepository, times(1)).findAll();
	}
}
