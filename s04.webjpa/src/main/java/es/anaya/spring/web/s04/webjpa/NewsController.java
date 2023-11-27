package es.anaya.spring.web.s04.webjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewsController {
	@Autowired
	private NewsRepository newsRepository;
	
  @RequestMapping("/news")
  public String showAll(Model model) {
    model.addAttribute("newsAll", newsRepository.findAll());
    return "showAll";
  }
  
  @RequestMapping("/news/{id}")
  public String show(@PathVariable("id") Long id, Model model) {
    model.addAttribute("news", newsRepository.findOne(id));
    return "detail";
  }

}
