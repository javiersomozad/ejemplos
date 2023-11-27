package es.anaya.spring.web.s04.springtaglib;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/tagMessage", method = RequestMethod.GET)
	public String tagMessage (Locale locale, Model model) {
		logger.info("Showing message tag sample.", locale);
		
		return "tagMessage";
	}
	
	/**
	 * Simply selects the tagUrl view to render by returning its name.
	 */
	@RequestMapping(value = "/tagUrl", method = RequestMethod.GET)
	public String tagUrl (Locale locale, Model model) {
		logger.info("Showing message tag sample.", locale);
		
		return "tagUrl";
	}
	
	/**
	 * Simply selects the tagTheme view to render by returning its name.
	 */
	@RequestMapping(value = "/tagTheme", method = RequestMethod.GET)
	public String tagTheme (Locale locale, Model model) {
		logger.info("Showing theme tag sample.", locale);
		
		return "tagTheme";
	}
	
	/**
	 * Simply selects the tagTransform view to render by returning its name.
	 */
	@RequestMapping(value = "/tagTransform", method = RequestMethod.GET)
	public String tagTransform (Locale locale, Model model) {
		logger.info("Showing transform tag sample.", locale);
		
		return "tagTransform";
	}
	
	/**
	 * Simply selects the tagEval view to render by returning its name.
	 */
	@RequestMapping(value = "/tagEval", method = RequestMethod.GET)
	public String tagEval (Locale locale, Model model) {
		logger.info("Showing eval tag sample.", locale);
		
		model.addAttribute("price",new Float(6));
		
		return "tagEval";
	}
	
	/**
	 * Simply selects the tagBind view to render by returning its name.
	 */
	@RequestMapping(value = "/tagBind", method = RequestMethod.GET)
	public String tagBind (Locale locale, Model model) {
		logger.info("Showing eval tag sample.", locale);
		
		model.addAttribute("customer", new Customer(31,"Juan Nadie","c\\ La <b>Buena Vida</b>", "jnadie@null.com"));
		
		return "tagBind";
	}
	
	/**
	 * Simply selects the tagEscapeBody view to render by returning its name.
	 */
	@RequestMapping(value = "/tagEscapeBody", method = RequestMethod.GET)
	public String tagEscapeBody (Locale locale, Model model) {
		logger.info("Showing escapeBody tag sample.", locale);
		
		return "tagEscapeBody";
	}
	
	/**
	 * Simply selects the tagHasBindErrors view to render by returning its name.
	 */
	@RequestMapping(value = "/tagHasBindErrors", method = RequestMethod.GET)
	public String tagHasBindErrors (Locale locale, Model model) {
		logger.info("Showing hasBindErrors tag sample.", locale);
		
		return "tagHasBindErrors";
	}
	
	/**
	 * Simply selects the tagHtmlEscape view to render by returning its name.
	 */
	@RequestMapping(value = "/tagHtmlEscape", method = RequestMethod.GET)
	public String tagHtmlEscape (Locale locale, Model model) {
		logger.info("Showing htmlEscape tag sample.", locale);

		model.addAttribute("dataWithHtml", "Some html <script>alert('fear me');</script>can be <b>dangerous</b>");
		
		return "tagHtmlEscape";
	}
	
	/**
	 * Simply selects the tagNestedPath view to render by returning its name.
	 */
	@RequestMapping(value = "/tagNestedPath", method = RequestMethod.GET)
	public String tagNestedPath (Locale locale, Model model) {
		logger.info("Showing nestedPath tag sample.", locale);
		
		return "tagNestedPath";
	}
	
}
