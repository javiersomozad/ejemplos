package es.anaya.spring.web.s04.flashattributes;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;

@Controller
public class AdvertController {
 
 @GetMapping("/advert")
 public String advertForm(Model model) {
  model.addAttribute("advert", new Advert());  
  return "advert";
 }

 @PostMapping("/advert")
 public String advertSubmit(@Valid Advert advert, 
 				BindingResult bindingResult, 
 				RedirectAttributes model) {
 	
  if (bindingResult.hasErrors()) {
  	model.addFlashAttribute("message", "There are errors");
  	model.addFlashAttribute("details", bindingResult.getAllErrors());
   return "redirect:/advert"; // GET /advert
  }
  
  model.addFlashAttribute("message", "Everything went fine");
  model.addFlashAttribute("advert", advert);
  return "redirect:/saved";
 }

 @GetMapping("/saved")
 public String advertSaved(Model model) {  
  return "advertSaved";
 }
}