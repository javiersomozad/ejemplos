package es.anaya.spring.web.s04.fileupload;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
	public Optional<Picture> getById(Long id);
	public List<Picture> getPictures();
	public PictureCommand savePicture(PictureCommand pictureCommand, MultipartFile file);
	public PictureCommand findPictureById(Long valueOf);
}
