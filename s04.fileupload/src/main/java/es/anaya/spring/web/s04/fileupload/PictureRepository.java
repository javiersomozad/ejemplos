package es.anaya.spring.web.s04.fileupload;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PictureRepository extends CrudRepository<Picture, Long> {
	List<Picture> findByName(String name);

}
