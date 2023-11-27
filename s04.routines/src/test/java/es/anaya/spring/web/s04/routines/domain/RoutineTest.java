package es.anaya.spring.web.s04.routines.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoutineTest {

	private Routine routine;

	@Before
	public void setUp() {
		routine = new Routine();
	}

	@Test
	public void shouldGetId() throws Exception {
		Long idValue = 4L;

		routine.setId(idValue);

		assertEquals(idValue, routine.getId());
	}

	@Test
	public void shouldGetTask() throws Exception {
		String task = "Test task";

		routine.setTask(task);

		assertEquals(task, routine.getTask());
	}

	@Test
	public void shouldGetImportance() throws Exception {
		Integer importance = 1;

		routine.setImportance(importance);

		assertEquals(importance, routine.getImportance());
	}

}