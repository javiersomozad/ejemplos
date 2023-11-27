package es.anaya.spring.web.s04.fortune;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import es.anaya.spring.web.s04.fortune.Fortune;

import java.util.List;

public interface FortuneRepository extends CrudRepository<Fortune, Long> {

    List<Fortune> findByQuote(String quote);
    List<Fortune> findByType(String type);
    List<Fortune> findByLang(String lang);
    
    @Query(value="select * from Fortune order by random() limit 1,1", nativeQuery = true)
    Fortune randomQuote();

    @Query(value="select * from Fortune where type=?1 order by random() limit 1,1", nativeQuery = true)
    Fortune randomQuoteByType(String type);
    
    @Query(value="select * from Fortune where lang=?1 order by random() limit 1,1", nativeQuery = true)
    Fortune randomQuoteByLang(String lang);
    
    @Query(value="select * from Fortune where type=?1 and lang=?2 order by random() limit 1,1", nativeQuery = true)
    Fortune randomQuoteBytTypeAndLang(String type, String lang);
}