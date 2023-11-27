package es.anaya.spring.services.s05.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
  private static final Logger log = 
		  LoggerFactory.getLogger(BatchConfiguration.class);
  
  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;
  
  @Autowired
  SimpleTasklet simpleTasklet;
  
  @Autowired
  OtherTasklet otherTasklet;
  
  @Bean
  public Step step1() {
	 	log.info("This is step 1 ");
	 	return stepBuilderFactory.get("step1")
	 		.tasklet(simpleTasklet)
	 		.build();
  }
  
  @Bean
  public Step step2() {
	 	log.info("This is step 2 ");
	 return stepBuilderFactory.get("step2")
		.tasklet(otherTasklet)
		.build();
  }
  
  @Bean
  public Job job(Step step1) throws Exception {
  return jobBuilderFactory.get("job1")
    .incrementer(new RunIdIncrementer())
    .start(step1())
    .next(step2())
    .build();
  }
}