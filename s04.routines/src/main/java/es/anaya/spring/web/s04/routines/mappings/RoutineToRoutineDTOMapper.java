package es.anaya.spring.web.s04.routines.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.anaya.spring.web.s04.routines.domain.Routine;
import es.anaya.spring.web.s04.routines.dto.RoutineDTO;

@Mapper(componentModel = "spring")
public interface RoutineToRoutineDTOMapper {
	RoutineToRoutineDTOMapper INSTANCE = 
			Mappers.getMapper(RoutineToRoutineDTOMapper.class);
	
	RoutineDTO routineToRoutineDTO(Routine routine);
	Routine routineDTOToRoutine(RoutineDTO routineDTO);
}



