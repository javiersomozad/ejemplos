package es.anaya.spring.web.s04.restapiswagger.mappings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.anaya.spring.web.s04.restapiswagger.domain.Video;
import es.anaya.spring.web.s04.restapiswagger.dto.VideoDTO;

@Component
public class VideoToVideoDTOMapper {

	@Autowired
	private AuthorToAuthorDTOMapper authorToAuthorDTOMapper;

	public VideoDTO videoToVideoDTO(Video video) {
		if (null == video) { return null; }

		VideoDTO videoDTO = new VideoDTO();
		
		videoDTO.setId(video.getId());
		videoDTO.setName(video.getName());
		videoDTO.setCreatedAt(video.getCreatedAt());
		videoDTO.setAuthorDTO(authorToAuthorDTOMapper.authorToAuthorDTO(video.getAuthor()));

		return videoDTO;
	}

	public Video videoDTOToVideo(VideoDTO videoDTO) {
		if (null == videoDTO) { return null; }
		
		Video video = new Video();
		
		video.setId(videoDTO.getId());
		video.setName(videoDTO.getName());
		video.setCreatedAt(videoDTO.getCreatedAt());
		video.setAuthor(authorToAuthorDTOMapper.authorDTOToAuthor(videoDTO.getAuthorDTO()));

		return video;
	}
}
