package es.anaya.spring.web.s04.customvalidator;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;

@Controller
public class CitizenController {
	
    @GetMapping("/citizen")
    public String citizenForm(Model model) {
    	Citizen citizen = new Citizen();
        model.addAttribute("citizen", citizen);
        return "citizen";
    }

    @PostMapping("/citizen")
    public String citizenSubmit(@Valid Citizen citizen, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        	System.err.println("Error in validation " 
        			+ bindingResult.getAllErrors());
            return "citizen";
        }
        return "citizenSaved";
    }
}
