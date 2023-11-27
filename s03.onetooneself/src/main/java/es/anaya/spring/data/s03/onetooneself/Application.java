package es.anaya.spring.data.s03.onetooneself;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Application implements CommandLineRunner {
 @Autowired
 PostRepository postRepository;

 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
 }

 @Transactional(readOnly = false)
 @Override
 public void run(String... args) throws Exception {

  System.out.println("Showing all: " + postRepository.findAll());

  Post post = postRepository.findById(3L).get();

  postRepository.delete(post);

  System.out.println("Showing all after: " + postRepository.findAll());
 }
}
