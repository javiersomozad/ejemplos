package es.anaya.spring.web.s04.fortune;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import es.anaya.spring.web.s04.fortune.Fortune;

@RestController
public class FortuneController {
	@Autowired
	private FortuneRepository fortuneRepository;
	
    @RequestMapping("/fortune")
    public Fortune fortune (Model model) {
        return fortuneRepository.randomQuote();
    }
    
    @RequestMapping("/fortune/{type}")
    public Fortune fortuneByType(@PathVariable("type") String type) {
    	  return fortuneRepository.randomQuoteByType(type);
    }

    
    @RequestMapping("/fortune/lang/{lang}")
    public Fortune fortuneByLang(@PathVariable("lang") String lang) {
    	return fortuneRepository.randomQuoteByLang(lang);
    }
    
    @RequestMapping("/fortune/{type}/lang/{lang}")
    public Fortune fortuneByTypeAndLang(@PathVariable("type") String type,@PathVariable("lang") String lang) {
    	return fortuneRepository.randomQuoteBytTypeAndLang(type, lang);
    } 
}
