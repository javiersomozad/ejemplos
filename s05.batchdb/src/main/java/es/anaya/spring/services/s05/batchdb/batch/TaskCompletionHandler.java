package es.anaya.spring.services.s05.batchdb.batch;

import javax.transaction.Transactional;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.anaya.spring.services.s05.batchdb.repositories.InvoiceRepository;

@Component
public class TaskCompletionHandler 
			extends JobExecutionListenerSupport {

  private InvoiceRepository invoiceRepository;

  @Autowired
  public TaskCompletionHandler(InvoiceRepository invoiceRepository) {
    this.invoiceRepository = invoiceRepository;
  }

  @Override
  @Transactional
  public void afterJob(JobExecution jobExecution) {
    if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
      int processed = invoiceRepository.markProcessed();
      System.out.println("Task completed. Invoices:  " + processed);
    }
  }
}
