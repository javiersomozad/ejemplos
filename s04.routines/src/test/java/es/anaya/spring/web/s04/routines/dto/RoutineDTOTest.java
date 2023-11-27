package es.anaya.spring.web.s04.routines.dto;

import org.junit.Before;
import org.junit.Test;

import es.anaya.spring.web.s04.routines.dto.RoutineDTO;

import static org.junit.Assert.assertEquals;

public class RoutineDTOTest {

	private RoutineDTO routineDTO;

	@Before
	public void setUp() {
		routineDTO = new RoutineDTO();
	}

	@Test
	public void shouldGetId() throws Exception {
		Long idValue = 4L;

		routineDTO.setId(idValue);

		assertEquals(idValue, routineDTO.getId());
	}

	@Test
	public void shouldGetTask() throws Exception {
		String task = "Test task";

		routineDTO.setTask(task);

		assertEquals(task, routineDTO.getTask());
	}

	@Test
	public void shouldGetImportance() throws Exception {
		Integer importance = 1;

		routineDTO.setImportance(importance);

		assertEquals(importance, routineDTO.getImportance());
	}

}