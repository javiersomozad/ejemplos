package es.anaya.spring.testing.s04.exceptions.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import es.anaya.spring.testing.s04.exceptions.command.ProductCommand;
import es.anaya.spring.testing.s04.exceptions.exceptions.ProductNotFoundException;
import es.anaya.spring.testing.s04.exceptions.services.ProductService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProductController {

	private ProductService productService;
		
  public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping("/product/{id}")
  public String detail (@PathVariable("id") Long id,Model model) {  	
  	model.addAttribute("product", productService.getById(id));
    return "product";
  }
	
	@RequestMapping("/products")
  public String list (Model model) {  	
    model.addAttribute("productCommand", new ProductCommand());
  	model.addAttribute("products", productService.getProducts());
    return "products";
  }
	
  @PostMapping("/products")
  public String saveMessage(Model model, @ModelAttribute ProductCommand productCommand) {
  	ProductCommand savedMessageCommand = productService.saveProduct(productCommand);
  	model.addAttribute("product", savedMessageCommand);
    return "productSaved";
  }
  
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(ProductNotFoundException.class)
  public ModelAndView handleNotFound(Exception exception){
    log.error("Not found: " + exception.getMessage());
    ModelAndView modelAndView = new ModelAndView();

    modelAndView.setViewName("productNotFound");
    modelAndView.addObject("exception", exception);

    return modelAndView;
}
}
