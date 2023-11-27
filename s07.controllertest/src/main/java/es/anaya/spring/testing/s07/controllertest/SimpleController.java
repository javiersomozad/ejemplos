package es.anaya.spring.testing.s07.controllertest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {

	@RequestMapping("/hello")
	public String hello(Model model) {
		return "hello";
	}

	@RequestMapping("/say")
	public String say(Model model) {
		model.addAttribute("something", "This is a message");
		return "saySomething";
	}
}
