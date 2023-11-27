package es.anaya.spring.data.s03.onetomany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	BrandRepository brandRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Transactional(readOnly = true)
	@Override
	public void run(String... args) throws Exception {

		System.out.println("Showing all records");
		for (Brand brand : brandRepository.findAll()) {
			System.out.println(brand);
		}

		System.out.println("Select by name");
		for (Brand brand : brandRepository.findByName("LG")) {
			System.out.println(brand);
		}

	}
}
