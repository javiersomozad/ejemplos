package es.anaya.spring.web.s04.restapimapstruct.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.anaya.spring.web.s04.restapimapstruct.domain.Program;
import es.anaya.spring.web.s04.restapimapstruct.dto.ProgramDTO;

@Mapper(componentModel = "spring")
public interface ProgramToProgramDTOMapper {
	ProgramToProgramDTOMapper INSTANCE = 
			Mappers.getMapper(ProgramToProgramDTOMapper.class);
	
	ProgramDTO programToProgramDTO(Program program);
	Program programDTOToProgram(ProgramDTO programDTO);
}



