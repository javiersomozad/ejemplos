package es.anaya.spring.web.s04.restapimapstruct.services;

import java.util.List;

import es.anaya.spring.web.s04.restapimapstruct.dto.ChannelDTO;

public interface ChannelService {
	public List<ChannelDTO> getAllChannels();
	public ChannelDTO getChannel(Long id);
	public ChannelDTO createChannel(ChannelDTO channelDTO);
    public ChannelDTO updateChannel(ChannelDTO channelDTO);
    public Long deleteChannel(Long id);
}
