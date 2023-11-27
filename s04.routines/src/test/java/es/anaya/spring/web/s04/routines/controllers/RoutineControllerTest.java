package es.anaya.spring.web.s04.routines.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import es.anaya.spring.web.s04.routines.domain.Routine;
import es.anaya.spring.web.s04.routines.dto.RoutineDTO;
import es.anaya.spring.web.s04.routines.services.RoutineService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

public class RoutineControllerTest {

	@Mock
	private RoutineService routineService;

	@Mock
	private Model model;

	RoutineController controller;
	List<RoutineDTO> routineDTOs;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		routineDTOs = new ArrayList<RoutineDTO>();
		controller = new RoutineController(routineService);
	}

    @Test
    public void shouldReturnIndex() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/routines"))
                .andExpect(status().isOk())
                .andExpect(view().name("read"));
    }
    
    @Test
    public void shouldReturnDetail() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/routines/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("detail"));
    }
    
    @Test
    public void shouldReturnCreate() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/routines/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("new"));
    }
    
    
    @Test
    public void shouldReturnUpdate() throws Exception {

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(get("/routines/update/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("update"));
    }
    
	@Test
	public void listShouldCallGetRoutines() throws Exception {

		String viewName = controller.list(model);

		assertEquals("read", viewName);
		verify(routineService, times(1)).findAll();
		verify(model, times(1)).addAttribute(eq("routines"), anyList());
	}

	@Test
	public void listShouldReturnListOfRoutines () throws Exception {
		// given
		initList();

		when(routineService.findAll()).thenReturn(routineDTOs);

		ArgumentCaptor<List<RoutineDTO>> argumentCaptor = ArgumentCaptor.forClass(List.class);

		// when
		String viewName = controller.list(model);

		// then
        assertEquals("read", viewName);
        verify(routineService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("routines"), argumentCaptor.capture());
		List<RoutineDTO> listInController = argumentCaptor.getValue();

		assertEquals(routineDTOs.size(), listInController.size());
        
	}
	
	@Test
	public void detailShouldCallFindById() throws Exception {

		String viewName = controller.detail(1L,model);

		assertEquals("detail", viewName);
		verify(routineService, times(1)).findById(1L);
		verify(model, times(1)).addAttribute( eq("routine"), anyObject());
	}
	
	@Test
	public void detailShouldReturnARoutine () throws Exception {
		// given
		RoutineDTO routineDTO = new RoutineDTO(1L, "A", 4);

		when(routineService.findById(1L)).thenReturn(routineDTO);

		ArgumentCaptor<RoutineDTO> argumentCaptor = ArgumentCaptor.forClass(RoutineDTO.class);

		// when
		String viewName = controller.detail(1L, model);

		// then
        assertEquals("detail", viewName);
        verify(routineService, times(1)).findById(1L);
        verify(model, times(1)).addAttribute(eq("routine"), argumentCaptor.capture());
		RoutineDTO routineInController = argumentCaptor.getValue();

		assertEquals(routineDTO.getId(), routineInController.getId());
        
	}

	private void initList() {
		routineDTOs.add(new RoutineDTO());
		routineDTOs.add(new RoutineDTO());
		routineDTOs.add(new RoutineDTO());
	}
}