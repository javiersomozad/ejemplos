package es.anaya.spring.web.s04.dbloginmysql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.anaya.spring.web.s04.dbloginmysql.domain.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	 User findByUsername(String username);
	 User findByEmail(String email);
}