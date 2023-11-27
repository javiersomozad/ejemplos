package es.anaya.spring.web.s04.mustache;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

	private Customer customer;
	
	public CustomerController () {
		init();
	}
	
	private void init() {
		customer = new Customer(42L, "Juan", "j@web.com",new Date());
		customer.setType(new CustomerType(1L,"VIP"));
		customer.getAccounts().add(new Account(1L,"ING","ES54-23423", true,66.6d));
		customer.getAccounts().add(new Account(2L,"EVO","ES54-54324",true, 42000.35d));
		customer.getAccounts().add(new Account(3L,"BSCH","ES52-94542",false, -0.5d));
	}
	
    @RequestMapping("/simple")
    public String simpleSample (Model model) {
    	model.addAttribute("greet", "Hello Mustache");
        return "simple";
    }
    
    @RequestMapping("/customer")
    public String customer (Model model) {
    	model.addAttribute("customer", customer);
        return "customer";
    }
    

    
}
