package es.anaya.spring.services.s05.batch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,BatchAutoConfiguration.class})
public class Application implements CommandLineRunner {
 @Autowired
 JobLauncher jobLauncher;
 
 @Autowired
 Job job;
	
  public static void main(String [] args) {
    System.exit(SpringApplication.exit(SpringApplication.run(
    		Application.class, args)));
  }
  
  @Override
  public void run(String... args) throws Exception {
	  JobParameters jobParameters = 
			  new JobParametersBuilder()
			  	.addLong("time", System.currentTimeMillis())
			  	.toJobParameters();
      jobLauncher.run(job, jobParameters);
  }
}
