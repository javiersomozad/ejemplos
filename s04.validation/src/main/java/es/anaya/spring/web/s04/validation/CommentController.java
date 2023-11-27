package es.anaya.spring.web.s04.validation;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;

@Controller
public class CommentController {

  @GetMapping("/")
  public String greetingForm() {
    return "index";
  }
  
  @GetMapping("/comment")
  public String commentForm(Model model) {
  	Comment comment = new Comment();
    model.addAttribute("comment", comment);    
    return "comment";
  }

  @PostMapping("/comment")
  public String commentSubmit(@Valid Comment comment, 
		  						BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
    	System.err.println("Error in validation " 
    			+ bindingResult.getAllErrors());
      return "comment";
    }
    return "commentSaved";
  }

}