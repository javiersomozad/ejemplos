package es.anaya.spring.web.s04.restapiswagger.service;

import java.util.List;

import es.anaya.spring.web.s04.restapiswagger.dto.VideoDTO;


public interface VideoService {
	public List<VideoDTO> getAllVideos();
	public VideoDTO getVideo(Long id);
	public VideoDTO createNewVideo(VideoDTO videoDTO);
	public VideoDTO saveVideo(Long id, VideoDTO videoDTO);
	public void deleteVideoById(Long id);

	
}
