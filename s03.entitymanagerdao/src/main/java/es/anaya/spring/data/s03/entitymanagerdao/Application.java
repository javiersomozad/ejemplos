package es.anaya.spring.data.s03.entitymanagerdao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class Application implements CommandLineRunner {
   @Autowired
   UniversityDAO universityDAO;
   
 public static void main(String[] args) {
  SpringApplication.run(Application.class, args);
 }
 
  @Transactional(readOnly = true)
  @Override
  public void run(String... args) throws Exception {

    System.out.println("All: " + universityDAO.findAll());
    
    University university = universityDAO.findById(1L);
    System.out.println("Found one: " + university);
    University university2 = new University();
    university2.setName("MIT");
    university2.setYear(1945);
    
    universityDAO.add(university2);
    System.out.println("All: " + universityDAO.findAll());
    
    university2.setYear(2010);
    universityDAO.update(university2);
    System.out.println("All: " + universityDAO.findAll());
    
    universityDAO.delete(university2);
    System.out.println("All: " + universityDAO.findAll());

   }
}
