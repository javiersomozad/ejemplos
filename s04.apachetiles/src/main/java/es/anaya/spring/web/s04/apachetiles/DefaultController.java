package es.anaya.spring.web.s04.apachetiles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
public class DefaultController {
 
	@RequestMapping("/")
	String home() {
		return "home";
	}
	
	@RequestMapping("/other")
	String other() {
		return "other";
	}
}