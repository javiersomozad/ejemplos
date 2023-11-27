package es.anaya.spring.data.s03.nativesql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	@Query(value = "SELECT * FROM USER order by random() limit 1,1", nativeQuery = true)
	public User findRandom();
	
	@Query(value = "SELECT * FROM USER LIMIT ?1, ?2", nativeQuery = true)
	public User findByLogin(Long login);

}
