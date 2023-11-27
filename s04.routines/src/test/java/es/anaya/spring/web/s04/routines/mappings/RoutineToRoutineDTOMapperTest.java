package es.anaya.spring.web.s04.routines.mappings;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.anaya.spring.web.s04.routines.domain.Routine;
import es.anaya.spring.web.s04.routines.dto.RoutineDTO;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoutineToRoutineDTOMapperTest {

	@Autowired
	private RoutineToRoutineDTOMapper routineToRoutineDTOMapper;

	@Before
	public void setUp() {
	}

	@Test
	public void shouldConvertToDTO() throws Exception {
		Routine routine = generateRoutine();
		RoutineDTO testedRoutineDTO = routineToRoutineDTOMapper.routineToRoutineDTO(routine);

		assertEquals(routine.getId(), testedRoutineDTO.getId());
		assertEquals(routine.getTask(), testedRoutineDTO.getTask());
		assertEquals(routine.getImportance(), testedRoutineDTO.getImportance());
	}

	@Test
	public void shouldConvertFromDTO() throws Exception {
		RoutineDTO routineDTO = generateRoutineDTO();
		Routine testedRoutine = routineToRoutineDTOMapper.routineDTOToRoutine(routineDTO);

		assertEquals(routineDTO.getId(), testedRoutine.getId());
		assertEquals(routineDTO.getTask(), testedRoutine.getTask());
		assertEquals(routineDTO.getImportance(), testedRoutine.getImportance());
	}

	private RoutineDTO generateRoutineDTO() {
		RoutineDTO routineDTO = new RoutineDTO();
		routineDTO.setId(1L);
		routineDTO.setTask("Test task");
		routineDTO.setImportance(3);

		return routineDTO;
	}

	private Routine generateRoutine() {
		Routine routine = new Routine();
		routine.setId(1L);
		routine.setTask("Test task");
		routine.setImportance(3);

		return routine;
	}

}