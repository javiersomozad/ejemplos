package es.anaya.spring.web.s04.restapiswagger.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.anaya.spring.web.s04.restapiswagger.dto.VideoDTO;
import es.anaya.spring.web.s04.restapiswagger.service.VideoService;


@Controller
@RequestMapping("/video")
public class VideoController {
	@Autowired
	private VideoService videoService;
	
    @GetMapping
    @ResponseBody
    public List<VideoDTO> getVideos() {
        return videoService.getAllVideos();
    }
    
    @GetMapping(value="/{id}")
    @ResponseBody
    public VideoDTO getVideo(@PathVariable("id") Long id) {
        return videoService.getVideo(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public VideoDTO createNewVideo(@RequestBody VideoDTO videoDTO){
        return videoService.createNewVideo(videoDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public VideoDTO updateVideo(@PathVariable Long id, @RequestBody VideoDTO videoDTO){
        return videoService.saveVideo(id, videoDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteVideo(@PathVariable Long id){
        videoService.deleteVideoById(id);
}

}
