package es.anaya.spring.web.s04.restapimapstruct.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import es.anaya.spring.web.s04.restapimapstruct.domain.Channel;
import es.anaya.spring.web.s04.restapimapstruct.dto.ChannelDTO;
import es.anaya.spring.web.s04.restapimapstruct.repositories.ChannelRepository;
import es.anaya.spring.web.s04.restapimapstruct.services.ChannelService;


@Controller
@RequestMapping("/channel")
public class ChannelController {
 @Autowired
 ChannelService channelService;
 
  @GetMapping
  @ResponseBody
  public ResponseEntity<List<ChannelDTO>> getChannels() {
   System.out.println("See: " + channelService.getAllChannels());
    return new ResponseEntity<List<ChannelDTO>>(channelService.getAllChannels(),
      HttpStatus.OK);
  }
  
  @GetMapping(value="/{id}")
  public ResponseEntity<ChannelDTO> getChannel(@PathVariable("id") Long id) {
    return new ResponseEntity<ChannelDTO>(channelService.getChannel(id),
       HttpStatus.OK);
  }
  
  @PostMapping
  public ResponseEntity<ChannelDTO> createChannel(@RequestBody ChannelDTO channelDTO){
    return new ResponseEntity<ChannelDTO>(channelService.createChannel(channelDTO),
        HttpStatus.CREATED);
  }

  @PutMapping({"/{id}"})
  public ResponseEntity<ChannelDTO> updateChannel(@PathVariable Long id, @RequestBody ChannelDTO channelDTO){
    return new ResponseEntity<ChannelDTO>(channelService.updateChannel( channelDTO),
        HttpStatus.OK);
  }
  
  @DeleteMapping({"/{id}"})
  public ResponseEntity<Long> deleteChannel(@PathVariable Long id){
    return new ResponseEntity<Long>(channelService.deleteChannel(id),
        HttpStatus.OK);
  }
 
}
