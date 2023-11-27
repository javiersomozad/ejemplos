package es.anaya.spring.testing.s07.integrationtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

	@Autowired
	CustomerData customers;
	
	public CustomerController () {
	}
	
    @RequestMapping("/customer")
    public String list (Model model) {
    	model.addAttribute("customers", customers.getCustomers());
        return "list";
    }
    
    @RequestMapping("/customer/new")
    public String newCustomer (Model model) {
    	model.addAttribute("customer", new Customer());
        return "new";
    }
    
    @PostMapping("/customer/new")
    public String saveNewCustomer (@ModelAttribute Customer customer) {
    	customers.getCustomers().add(customer);
        return "redirect:/customer";
    }
}
