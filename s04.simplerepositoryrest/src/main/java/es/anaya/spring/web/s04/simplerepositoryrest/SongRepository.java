package es.anaya.spring.web.s04.simplerepositoryrest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "song", path = "song")
public interface SongRepository extends PagingAndSortingRepository<Song, Long> {
    List<Song> findByTitle(String title);
    List<Song> findByArtist(String artist);
}