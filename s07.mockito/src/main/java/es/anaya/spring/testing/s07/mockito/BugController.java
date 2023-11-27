package es.anaya.spring.testing.s07.mockito;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BugController {

	@Autowired
	BugService bugService;
	
    @RequestMapping("/bugs")
    public String list (Model model) {
    	model.addAttribute("bugs", bugService.getBugs());
    	Optional<Bug> bug = bugService.getById(1L);
    	System.out.println("Show this: " + bug);
        return "bugs";
    }
}
