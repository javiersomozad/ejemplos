package es.anaya.spring.data.s03.mongodbembed;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
 
 @Autowired
 private NoteRepository repository;

 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
 }
 
 @Override
 public void run(String... args) throws Exception {

  repository.deleteAll();
  Note note = new Note("Learn ES6");
  List<Change> changes = Arrays.asList(new Change("Learn ES7"),new Change("Learn ES8 too") );
  note.setAuthor(new Author("Juan","juan@wer.com"));
  note.setChanges(changes);
  
  System.out.println(note);;
  repository.save(note);
  
  repository.save(new Note("Don't forget to learn Spring5"));
  repository.save(new Note("Don't forget to learn MongoDB"));
  repository.save(new Note("Don't forget to learn Java9"));
  
  System.out.println(repository.findAll());

 }

}
