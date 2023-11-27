package es.anaya.spring.web.s04.routines.services;

import java.util.List;

import es.anaya.spring.web.s04.routines.domain.Routine;
import es.anaya.spring.web.s04.routines.dto.RoutineDTO;

public interface RoutineService {

	public List<RoutineDTO> findAll ();
	public RoutineDTO  findById(Long id);
	public RoutineDTO save(RoutineDTO routineDTO);
	public void update(RoutineDTO routineDTO);
	public void remove (Long id);

}
