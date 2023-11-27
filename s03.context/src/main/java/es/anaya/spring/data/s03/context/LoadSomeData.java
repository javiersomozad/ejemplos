package es.anaya.spring.data.s03.context;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class LoadSomeData implements ApplicationListener<ContextRefreshedEvent> {

  private DirectorRepository directorRepository;
  private MovieRepository movieRepository;

  public LoadSomeData(DirectorRepository directorRepository, MovieRepository movieRepository) {
    this.directorRepository = directorRepository;
    this.movieRepository = movieRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }

  private void initData(){
   System.out.println("Here we are, ready to Rock...");
   Director goodDirector = new Director("Ridley Scott","USA");
   Director betterDirector = new Director("Denis Villeneuve", "Canada");
  
   Movie movie0 = new Movie("Alien", 1979, goodDirector);
   Movie movie1 = new Movie("Gladiator", 200, goodDirector);
   Movie movie2 = new Movie("Blade Runner 2049", 2017, betterDirector);
   
   directorRepository.save(goodDirector);
   directorRepository.save(betterDirector);
   
   movieRepository.save(movie0);
   movieRepository.save(movie1);
   movieRepository.save(movie2);
   
  }
}