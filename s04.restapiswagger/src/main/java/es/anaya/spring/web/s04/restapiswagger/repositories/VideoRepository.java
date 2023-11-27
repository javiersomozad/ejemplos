package es.anaya.spring.web.s04.restapiswagger.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import es.anaya.spring.web.s04.restapiswagger.domain.Video;

import java.util.List;


public interface VideoRepository  extends PagingAndSortingRepository<Video, Long> {
    List<Video> findByName(String name);
}