package es.anaya.spring.web.s04.restapimapstruct.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import es.anaya.spring.web.s04.restapimapstruct.domain.Channel;

public interface ChannelRepository  extends JpaRepository<Channel, Long> {
    List<Channel> findByName(String name);
}