package es.anaya.spring.web.s04.webflow;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping({"/"})
	public String sayHelloPage(Map<String, Object> model) {
		model.put("message", "Hello World, welcome to SignUp APP");
		
		// We return view name
		return "home";
	}

}