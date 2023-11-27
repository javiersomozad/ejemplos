package es.anaya.spring.data.s03.mongoreactive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application  implements CommandLineRunner {
	
	@Autowired
	private NoteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();
		Note note = new Note();

		repository.save(new Note("Don't forget to learn Spring5"));
		repository.save(new Note("Don't forget to learn MongoDB"));
		repository.save(new Note("Don't forget to learn Java9"));
		
		for (Note n : repository.findAll()) {
			System.out.println(n);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Single");
		System.out.println(repository.findByText("Don't forget to learn Java9"));

	}

}
