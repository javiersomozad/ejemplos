package es.anaya.spring.reactive.s06.reactiveweb;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class NoteController {
	@Autowired
	private NoteReactiveRepository noteReactiveRepository;
	
    @RequestMapping("/notes")
    public String read(Model model) {
        model.addAttribute("notes", noteReactiveRepository.findAll());
        return "read";
    }
    
    @RequestMapping("/notes/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("note", noteReactiveRepository.findById(id));
        return "detail";
    }

    
    @RequestMapping("/notes/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
    	noteReactiveRepository.deleteById(id);
        return "forward:/notes";  // Forward happens on the server
    }
    
    @RequestMapping("/notes/create")
    public String create(Model model) {
        model.addAttribute("note", new Note());
        return "create";
    }
    
    @PostMapping("/notes/create")
    public String saveCreate(Note note) {
    	System.out.println("Saving note: " + note);
    	noteReactiveRepository.save(note);
        return "forward:/notes";  // Forward happens on the server
    }
    
    @RequestMapping("/notes/update/{id}")
    public String update(@PathVariable("id") Integer id,Model model) {
        model.addAttribute("note", noteReactiveRepository.findById(id));
        return "update";
    }
    
    @PostMapping("/notes/update")
    public String saveUpdate(Note note) {
    	System.out.println("Updating note: " + note);
    	noteReactiveRepository.save(note);
        return "forward:/notes";  // Forward happens on the server
    }
    
}
