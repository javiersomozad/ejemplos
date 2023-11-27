package es.anaya.spring.web.s04.restapimapstruct.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import es.anaya.spring.web.s04.restapimapstruct.domain.Channel;
import es.anaya.spring.web.s04.restapimapstruct.dto.ChannelDTO;
import es.anaya.spring.web.s04.restapimapstruct.mappings.ChannelToChannelDTOMapper;
import es.anaya.spring.web.s04.restapimapstruct.repositories.ChannelRepository;

@Service
public class ChannelServiceImpl implements ChannelService {

  private ChannelToChannelDTOMapper channelToChannelDTOMapper;

  private ChannelRepository channelRepository;

  public ChannelServiceImpl(ChannelToChannelDTOMapper channelToChannelDTOMapper,
      ChannelRepository channelRepository) {
    this.channelToChannelDTOMapper = channelToChannelDTOMapper;
    this.channelRepository = channelRepository;
  }

  @Override
  public List<ChannelDTO> getAllChannels() {
    return channelRepository
        .findAll()
        .stream()
        .map(channelToChannelDTOMapper::channelToChannelDTO)
        .collect(Collectors.toList());
  }

  @Override
  public ChannelDTO getChannel(Long id) {
    return channelToChannelDTOMapper
          .channelToChannelDTO(channelRepository.findById(id).get());
  }

  @Override
  public ChannelDTO createChannel(ChannelDTO channelDTO) {
    Channel savedChannel = channelRepository
          .save(channelToChannelDTOMapper
          .channelDTOToChannel(channelDTO));
    return channelToChannelDTOMapper
          .channelToChannelDTO(savedChannel);
  }
  
  @Override
  public ChannelDTO updateChannel(ChannelDTO channelDTO) {
      return createChannel(channelDTO);
  }
    
  @Override
  public Long deleteChannel(Long id) {
      channelRepository.deleteById(id);
      return id;
  }
}
