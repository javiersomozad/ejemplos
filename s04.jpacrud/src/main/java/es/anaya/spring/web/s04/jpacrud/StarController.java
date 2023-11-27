package es.anaya.spring.web.s04.jpacrud;

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
public class StarController {
@Autowired
private StarRepository starsRepository;

    @RequestMapping("/stars")
    public String read(Model model) {
        model.addAttribute("stars", starsRepository.findAll());
        return "read";
    }
    
    @RequestMapping("/stars/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("star", starsRepository.findById(id));
        return "detail";
    }

    
    @RequestMapping("/stars/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        starsRepository.deleteById(id);
        return "forward:/stars";  // Forward happens on the server
    }
    
    @RequestMapping("/stars/create")
    public String create(Model model) {
        model.addAttribute("star", new Star());
        return "create";
    }
    
    @PostMapping("/stars/create")
    public String saveCreate(Star star) {
    System.out.println("Saving star: " + star);
    starsRepository.save(star);
        return "forward:/stars";  // Forward happens on the server
    }
    
    @RequestMapping("/stars/update/{id}")
    public String update(@PathVariable("id") Long id,Model model) {
        model.addAttribute("star", starsRepository.findById(id));
        return "update";
    }
    
    @PostMapping("/stars/update")
    public String saveUpdate(Star star) {
    System.out.println("Updating star: " + star);
    starsRepository.save(star);
        return "forward:/stars";  // Forward happens on the server
    }
    
}
