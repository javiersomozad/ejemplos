package es.anaya.spring.web.s04.dblogin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.anaya.spring.web.s04.dblogin.domain.User;
import es.anaya.spring.web.s04.dblogin.services.UserService;


@Controller
public class HomeController {

  private UserService userService;
  
  public HomeController (UserService userService) {
  this.userService = userService;
  }
  
  @GetMapping("/public")
  public String publicPage() {
    return "public";
  }
  
  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }
  
  @GetMapping("/register")
  public String registerPage(Model model) {
    model.addAttribute("user", new User());
    return "register";
  }
  
  @PostMapping(value = "/register")
  public String createNewUser(User user, BindingResult bindingResult, Model model) {
  User userExists = userService.findUserByUsername(user.getUsername());
  if (userExists != null) {
    model.addAttribute("message", "Username already registered");
    return "register";
  }  else {
    userService.saveUser(user);
    model.addAttribute("message", "Successful registration. Please login");
    return "login";
  }
}
  
  @GetMapping("/protected")
  public String protectedPage() {
    return "protected";
  }
  
  @GetMapping("/admin")
  public String adminPage() {
    return "admin/home";
  } 

}