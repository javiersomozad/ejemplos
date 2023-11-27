package es.anaya.spring.services.s05.batchdb.batch;

import org.springframework.batch.item.ItemProcessor;

import es.anaya.spring.services.s05.batchdb.domain.BankReceipt;
import es.anaya.spring.services.s05.batchdb.domain.Customer;
import es.anaya.spring.services.s05.batchdb.domain.Invoice;

public class CustomerProcessor 
	implements ItemProcessor<Customer, BankReceipt> {
	
  @Override
  public BankReceipt process(Customer customer) throws Exception { 
   Double total = 0d;

   for(Invoice invoice : customer.getInvoices()) {
    total += invoice.getAmount();
   }
   
   BankReceipt bankReceipt = new BankReceipt(customer, total);
   System.out.println("Processor> Customer processed : " + bankReceipt);
    
   return bankReceipt;
  }
}