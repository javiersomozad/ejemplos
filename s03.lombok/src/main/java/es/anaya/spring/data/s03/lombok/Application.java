package es.anaya.spring.data.s03.lombok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import javax.sql.DataSource;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	DataSource dataSource;

	@Autowired
	MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Transactional(readOnly = true)
	@Override
	public void run(String... args) throws Exception {

		Movie movie = new Movie();
		
		movieRepository.save(movie);
		
		System.out.println("Showing all movies");
		for (Movie m : movieRepository.findAll()) {
			System.out.println(m);
		}

		
	}
}
