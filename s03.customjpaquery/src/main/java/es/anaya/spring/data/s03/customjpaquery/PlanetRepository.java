package es.anaya.spring.data.s03.customjpaquery;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface PlanetRepository 
	extends CrudRepository<Planet, Long>, PlanetAdvancedQueries {
 
  List<Planet> findByName(String name);
  List<Planet> findByDiameter(Double diameter);

  @Query("select p from Planet p where p.diameter >= :diam")
  List<Planet> findByBiggerThan(@Param("diam") Double diameter);
  
  @Query("select p from Planet p where p.diameter > ?1")
  List<Planet> findByBiggerThanPosition(Double diameter);
  
  @Query("select t from Planet t where t.name = :name")
  Stream<Planet> findByNameReturnStream(@Param("name") String name);
  
  @Query(value = "SELECT * FROM planet order by rand() limit 1,1", nativeQuery = true)
  public Planet findRandom();
 
  @Query(value = "SELECT * FROM planet LIMIT ?1, ?2", nativeQuery = true)
  public List<Planet> findPaginated(Integer start, Integer page);
 
  @Modifying
  @Query("delete from Planet p where p.diameter < 1000 ")
  void deleteDwarfs();

  @Modifying
  @Query("update Planet p set p.name = concat(p.name, ' Dwarf') where p.diameter < :diameter")
  void updateNameForDwarfs(@Param("diameter") Double diamenter);
  
}