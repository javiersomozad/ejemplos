package es.anaya.spring.services.s05.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class SimpleTasklet implements Tasklet{
   
  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) {
    System.out.println("The simple tasklet");
    return null;
  }
}
