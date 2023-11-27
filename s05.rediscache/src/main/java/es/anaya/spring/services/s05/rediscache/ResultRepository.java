package es.anaya.spring.services.s05.rediscache;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Date;
import java.util.List;

public interface ResultRepository 
	extends CrudRepository<Result, Long> {

  List<Result> findByEvent(String event);
  List<Result> findByDate(Date date);
  
  @Modifying
  @Query("delete from Result p where p.date = ?1 ")
  void deleteByDate(Date resultDate); 
}