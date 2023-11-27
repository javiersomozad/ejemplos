package es.anaya.spring.web.s04.fileupload;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PictureController {

	private PictureService pictureService;
		
    public PictureController(PictureService pictureService) {
		this.pictureService = pictureService;
	}

	@RequestMapping("/pictures")
    public String list (Model model) {    	
        model.addAttribute("pictureCommand", new PictureCommand());
    	model.addAttribute("pictures", pictureService.getPictures());
        return "pictures";
    }
	
    @PostMapping("/pictures")
    public String saveMessage(Model model, @ModelAttribute PictureCommand pictureCommand, @RequestParam("imagefile") MultipartFile file) {
    	PictureCommand savedPictureCommand = pictureService.savePicture(pictureCommand, file);
    	log.info("Uploaded image: " + file.getName());
    	model.addAttribute("picture", savedPictureCommand);
        return "pictureSaved";
    }
    
	@RequestMapping("/pictures/image/{id}")
    public void getImage (@PathVariable String id, HttpServletResponse response) throws IOException {
        PictureCommand pictureCommand = pictureService.findPictureById(Long.valueOf(id));

        if (pictureCommand.getContent() != null) {
            byte[] byteArray = new byte[pictureCommand.getContent().length];
            int i = 0;

            for (Byte wrappedByte : pictureCommand.getContent()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
}
}
