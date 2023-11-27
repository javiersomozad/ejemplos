package es.anaya.spring.web.s04.fileupload;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PictureServiceImpl implements PictureService {

	private PictureRepository pictureRepository;
	private PictureToPictureCommand pictureToPictureCommand;
	private PictureCommandToPicture pictureCommandToPicture;
	
	
	
	public PictureServiceImpl(PictureRepository pictureRepository, 
			PictureToPictureCommand pictureToPictureCommand,
			PictureCommandToPicture pictureCommandToPicture) {
		this.pictureRepository = pictureRepository;
		this.pictureToPictureCommand = pictureToPictureCommand;
		this.pictureCommandToPicture = pictureCommandToPicture;
	}

	@Override
	public Optional<Picture> getById(Long id) {
		return pictureRepository.findById(id);
	}

	@Override
	public List<Picture> getPictures() {
		return (List<Picture>)pictureRepository.findAll();
	}

	@Override
	public PictureCommand savePicture(PictureCommand pictureCommand, MultipartFile file) {
		Picture picture = pictureCommandToPicture.convert(pictureCommand);
		
		Byte[] byteObjects = getFileBytes(file);

        picture.setContent(byteObjects);
        
		Picture savedMessage = pictureRepository.save(picture);
		
		return pictureToPictureCommand.convert(savedMessage);
	}

	private Byte[] getFileBytes(MultipartFile file)  {
		Byte[] byteObjects = new Byte[1];
		
		try {
			byteObjects = new Byte[file.getBytes().length];
         int i = 0;

         for (byte b : file.getBytes()){
             byteObjects[i++] = b;
         }
		} catch (IOException ioe) {
			log.error("Error getting bytes fron file: " + ioe.getMessage());
		}
         
		return byteObjects;
	}

	@Override
	public PictureCommand findPictureById(Long valueOf) {
		return pictureToPictureCommand.convert(pictureRepository.findById(valueOf).get());
	}

}
