package es.anaya.spring.web.s04.restapimapstruct.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import es.anaya.spring.web.s04.restapimapstruct.domain.Channel;
import es.anaya.spring.web.s04.restapimapstruct.dto.ChannelDTO;

@Mapper(componentModel = "spring")
public interface ChannelToChannelDTOMapper {
	ChannelToChannelDTOMapper INSTANCE = 
			Mappers.getMapper(ChannelToChannelDTOMapper.class);
	
	ChannelDTO channelToChannelDTO(Channel channel);
	Channel channelDTOToChannel(ChannelDTO channelDTO);
}



