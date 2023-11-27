package es.anaya.spring.data.s03.jpamultisource.mysqlsource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MysqlCustomerRepository 
		extends JpaRepository<Customer, Long> {
}
