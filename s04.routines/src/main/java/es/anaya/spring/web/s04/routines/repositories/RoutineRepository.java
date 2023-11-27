package es.anaya.spring.web.s04.routines.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.anaya.spring.web.s04.routines.domain.Routine;

import java.util.List;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Long> {
	List<Routine> findByTask(String task);

	List<Routine> findByImportance(Integer importance);
}