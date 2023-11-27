package es.anaya.spring.web.s04.routines.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import es.anaya.spring.web.s04.routines.domain.Routine;
import es.anaya.spring.web.s04.routines.dto.RoutineDTO;
import es.anaya.spring.web.s04.routines.repositories.RoutineRepository;
import  es.anaya.spring.web.s04.routines.mappings.RoutineToRoutineDTOMapper;

@Service
public class RoutineServiceImpl implements RoutineService {
	
	private RoutineRepository routineRepository;
	private RoutineToRoutineDTOMapper routineToRoutineDTOMapper;

	public RoutineServiceImpl(RoutineRepository routineRepository,RoutineToRoutineDTOMapper routineToRoutineDTOMapper) {
		this.routineRepository = routineRepository;
		this.routineToRoutineDTOMapper = routineToRoutineDTOMapper;
	}

	@Override
	public List<RoutineDTO> findAll() {
		return routineRepository
		        .findAll()
		        .stream()
		        .map(routineToRoutineDTOMapper::routineToRoutineDTO)
		        .collect(Collectors.toList());

	}	

	@Override
	public RoutineDTO findById(Long id) {
		return routineToRoutineDTOMapper.routineToRoutineDTO(routineRepository.findById(id).get());
	}

	@Override
	public RoutineDTO save(RoutineDTO routineDTO) {
		Routine routine = routineToRoutineDTOMapper.routineDTOToRoutine(routineDTO);
		return routineToRoutineDTOMapper.routineToRoutineDTO(routineRepository.save(routine));
	}

	@Override
	public void update(RoutineDTO routineDTO) {
		save(routineDTO);
	}

	@Override
	public void remove(Long id) {
		routineRepository.deleteById(id);
	}
	

}
