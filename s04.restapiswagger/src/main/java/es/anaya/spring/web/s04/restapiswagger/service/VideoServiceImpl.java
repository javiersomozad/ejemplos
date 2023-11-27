package es.anaya.spring.web.s04.restapiswagger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import es.anaya.spring.web.s04.restapiswagger.domain.Video;
import es.anaya.spring.web.s04.restapiswagger.dto.VideoDTO;
import es.anaya.spring.web.s04.restapiswagger.mappings.VideoToVideoDTOMapper;
import es.anaya.spring.web.s04.restapiswagger.repositories.VideoRepository;

@Service
public class VideoServiceImpl implements VideoService {

	private VideoToVideoDTOMapper videoToVideoDTOMapper;

	private VideoRepository videoRepository;

	public VideoServiceImpl(VideoToVideoDTOMapper videoToVideoDTOMapper, 
							VideoRepository videoRepository) {
		this.videoToVideoDTOMapper = videoToVideoDTOMapper;
		this.videoRepository = videoRepository;
	}

	@Override
	public List<VideoDTO> getAllVideos() {
		Iterable<Video> videos = videoRepository.findAll();
		List<VideoDTO> videoDTOs = new ArrayList<VideoDTO>();
		
		for (Video v : videos) {
			videoDTOs.add(videoToVideoDTOMapper.videoToVideoDTO(v));
		}
		
		return videoDTOs;
	}

	@Override
	public VideoDTO getVideo(Long id) {
		return videoToVideoDTOMapper.videoToVideoDTO(videoRepository.findById(id).get());
	}

	@Override
	public VideoDTO createNewVideo(VideoDTO videoDTO) {
		return saveVideo(null, videoDTO);
	}
	
	@Override
	public VideoDTO saveVideo(Long id, VideoDTO videoDTO) {
		Video video = videoRepository.save(videoToVideoDTOMapper.videoDTOToVideo(videoDTO));
		
		return videoToVideoDTOMapper.videoToVideoDTO(video);
	}

	@Override
	public void deleteVideoById(Long id) {
		videoRepository.deleteById(id);
		
	}



}
