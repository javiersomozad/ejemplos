package es.anaya.spring.services.s05.batchdb.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;

import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import es.anaya.spring.services.s05.batchdb.domain.BankReceipt;
import es.anaya.spring.services.s05.batchdb.domain.Customer;

import org.springframework.batch.item.database.JpaPagingItemReader;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableBatchProcessing
public class BatchTaskConfig {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Autowired
  private EntityManagerFactory entityManagerFactory;

  @Bean
  public ItemReader<Customer> reader() throws Exception {
    String jpqlQuery = "select c from Customer c";
    System.out.println("Task> Getting reader ");
    JpaPagingItemReader<Customer> reader = new JpaPagingItemReader<Customer>();
    
    reader.setQueryString(jpqlQuery);
    reader.setEntityManagerFactory(entityManagerFactory);
    reader.setPageSize(3);
    reader.afterPropertiesSet();
    reader.setSaveState(true);

    return reader;
  }

  @Bean
  public CustomerProcessor processor() {
    return new CustomerProcessor();
  }

  @Bean
  public ItemWriter<BankReceipt> writer() {
    FlatFileItemWriter<BankReceipt> writer = new FlatFileItemWriter<BankReceipt>();
    DelimitedLineAggregator<BankReceipt> lineAggregator = new DelimitedLineAggregator<>();
    BeanWrapperFieldExtractor<BankReceipt> extractor = new BeanWrapperFieldExtractor<>();

    System.out.println("Task> Getting writer ");
    extractor.setNames(new String[] { "name", "dni", "account", "total" });

    lineAggregator.setDelimiter(";");
    lineAggregator.setFieldExtractor(extractor);

    writer.setResource(new FileSystemResource("/tmp/bank-data.csv"));
  //  writer.setResource(new ClassPathResource("bank-data.csv")); // Other option
    writer.setLineAggregator(lineAggregator);
  

    return writer;
  }
  
  @Bean
  ItemWriter<BankReceipt> xmlWriter() {
    StaxEventItemWriter<BankReceipt> xmlFileWriter = new StaxEventItemWriter<>();
     
    xmlFileWriter.setResource(new FileSystemResource("/tmp/bank-data.xml"));
    //xmlFileWriter.setResource( new ClassPathResource("bank-data.xml"));
     
    xmlFileWriter.setRootTagName("receipts");
     
    Jaxb2Marshaller receiptMarshaller = new Jaxb2Marshaller();
    receiptMarshaller.setClassesToBeBound(BankReceipt.class);
    xmlFileWriter.setMarshaller(receiptMarshaller);
     
    return xmlFileWriter;
  }

  @Bean
  public Job importUserJob(TaskCompletionHandler listener) throws Exception {
    return jobBuilderFactory
    		.get("importUserJob")
    		.incrementer(new RunIdIncrementer())
    		.listener(listener)
    		.flow(step1())
    		.end()
    		.build();
  }

  @Bean
  public Step step1() throws Exception {
    return stepBuilderFactory
    		.get("step1")
    		.<Customer, BankReceipt>chunk(10)
    		.reader(reader())
    		.processor(processor())
    		.writer(writer())
    		.build();
  }

}