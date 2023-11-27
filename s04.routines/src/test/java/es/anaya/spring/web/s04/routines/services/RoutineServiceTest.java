package es.anaya.spring.web.s04.routines.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.anaya.spring.web.s04.routines.mappings.RoutineToRoutineDTOMapper;
import es.anaya.spring.web.s04.routines.services.RoutineServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import es.anaya.spring.web.s04.routines.domain.Routine;
import es.anaya.spring.web.s04.routines.dto.RoutineDTO;
import es.anaya.spring.web.s04.routines.repositories.RoutineRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoutineServiceTest {

    private RoutineServiceImpl routineService;
    @Autowired
    private RoutineToRoutineDTOMapper routineToRoutineDTOMapper;
    
    @Mock
    private RoutineRepository routineRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        routineService = new RoutineServiceImpl(routineRepository, routineToRoutineDTOMapper);
    }

    @Test
    public void shouldCallFindAll() throws Exception {
        ArrayList<RoutineDTO> routineData = new ArrayList<RoutineDTO>();
        routineData.add(new RoutineDTO(1L,"a",2));
        routineData.add(new RoutineDTO(2L,"b",3));
        
        ArrayList<Routine> routines = new ArrayList<Routine>();
        routines.add(new Routine());
        routines.add(new Routine());
        
        when(routineService.findAll()).thenReturn(routineData);
        when(routineRepository.findAll()).thenReturn(routines);
        
       routineService.findAll();

        assertEquals(routines.size(), 2);
        verify(routineRepository, times(1)).findAll();
    }
    
    @Test
    public void shouldCallCreate() throws Exception {
    	RoutineDTO routineDTO = new RoutineDTO(1L,"A",4);
    	Routine routine = routineToRoutineDTOMapper.routineDTOToRoutine(routineDTO);
    	
        routineService.save(routineDTO);
        verify(routineRepository, times(1)).save(routine);
    }
    
    @Test
    public void shouldCallUpdate() throws Exception {
    	RoutineDTO routineDTO = new RoutineDTO(1L,"A",4);
    	Routine routine = routineToRoutineDTOMapper.routineDTOToRoutine(routineDTO);
    	
        routineService.update(routineDTO);
        verify(routineRepository, times(1)).save(routine);
    }
    
    @Test
    public void shouldCallDelete() throws Exception {
        routineService.remove(1L);
        verify(routineRepository, times(1)).deleteById(1L);
    }
    
}