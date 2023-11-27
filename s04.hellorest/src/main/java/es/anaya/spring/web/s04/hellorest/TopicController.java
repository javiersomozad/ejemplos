package es.anaya.spring.web.s04.hellorest;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	private List<Topic> topics = new ArrayList<Topic>();
	
	public TopicController () {
	  	topics.add(new Topic(1L, "This is a topic"));
    	topics.add(new Topic(2L, "Another topic"));    	
    	topics.add(new Topic(3L, "The last topic"));
	}
	
    @RequestMapping("/topic/all")
    public List<Topic> getAllTopics() {
        return topics;
    }
    
    @RequestMapping("/topic/{idx}")
    public Topic getTopic(@PathVariable("idx") Integer idx) {
        return topics.get(idx);
    }
}