
package es.anaya.spring.web.s04.routines.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.anaya.spring.web.s04.routines.domain.Routine;
import es.anaya.spring.web.s04.routines.dto.RoutineDTO;
import es.anaya.spring.web.s04.routines.services.RoutineService;

@Controller
public class RoutineController {
	
	private RoutineService routineService;
	
	RoutineController (RoutineService routineServiceImpl) {
		this.routineService = routineServiceImpl;
	}
	
	@RequestMapping({"/routines"})
	public String list (Model model) {
		model.addAttribute("routines", routineService.findAll());
		return "read";
	}

	  @RequestMapping("/routines/{id}")
	    public String detail(@PathVariable("id") Long id, Model model) {
	        model.addAttribute("routine", routineService.findById(id));
	        return "detail";
	    }

	    
	    @RequestMapping("/routines/delete/{id}")
	    public String delete(@PathVariable("id") Long id, Model model) {
	    	routineService.remove(id);
	        return "forward:/routines";  // Forward happens on the server
	    }
	    
	    @RequestMapping("/routines/create")
	    public String create(Model model) {
	        model.addAttribute("routineDTO", new RoutineDTO());
	        return "new";
	    }
	    
	    @PostMapping("/routines/create")
	    public String saveCreate(RoutineDTO routineDTO) {
	    	System.out.println("Saving routine: " + routineDTO);
	    	routineService.save(routineDTO);
	        return "forward:/routines";  // Forward happens on the server
	    }
	    
	    @RequestMapping("/routines/update/{id}")
	    public String update(@PathVariable("id") Long id,Model model) {
	        model.addAttribute("routineDTO", routineService.findById(id));
	        return "update";
	    }
	    
	    @PostMapping("/routines/update")
	    public String saveUpdate(RoutineDTO routineDTO) {
	    System.out.println("Updating routine: " + routineDTO);
	    routineService.save(routineDTO);
	        return "forward:/routines";  // Forward happens on the server
	    }
	    
	
}
