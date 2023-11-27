package es.anaya.spring.data.s03.enums;




import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    List<Player> findByName(String name);
    List<Player> findByPosition(Position position);
}