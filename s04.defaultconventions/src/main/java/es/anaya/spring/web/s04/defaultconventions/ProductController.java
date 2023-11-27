package es.anaya.spring.web.s04.defaultconventions;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping
    public List<Product> read() {
        return (List<Product>)productRepository.findAll();
    }
	
	@PostMapping
    public String saveCreate(Product product) {
    	productRepository.save(product);
        return "redirect:/products";
    }
}
