package es.anaya.spring.data.s03.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Application  implements CommandLineRunner {
	
	@Autowired
	private DirectorRepository directorRepository;
	@Autowired
	private MovieRepository movieRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	  @Transactional(readOnly = true)
	    @Override
	    public void run(String... args) throws Exception {

	        System.out.println("Showing all movie records");
	        for (Movie movie : movieRepository.findAll()) {
	            System.out.println(movie);
	        }
	        

	        System.out.println("Showing all director records");
	        for (Director director : directorRepository.findAll()) {
	            System.out.println(director);
	        }
	    }
}
