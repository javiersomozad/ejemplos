package es.anaya.spring.web.s04.i18n;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InvoiceController {
  @GetMapping("/")
  public String greetingForm() {
    return "index";
  }
  
  @GetMapping("/invoice")
  public String commentForm(Model model) {
  	Invoice invoice = new Invoice();
    model.addAttribute("invoice", invoice);
   
    return "invoice";
  }

  @PostMapping("/invoice")
  public String commentSubmit(@Valid Invoice invoice, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
    	System.err.println("Error in validation " 
    			+ bindingResult.getAllErrors());
      return "invoice";
    }
    return "invoiceSaved";
  }

}
