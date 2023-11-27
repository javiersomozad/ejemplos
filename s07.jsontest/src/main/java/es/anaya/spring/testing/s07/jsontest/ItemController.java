package es.anaya.spring.testing.s07.jsontest;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
	
	@Autowired
	private ItemsMockRepository itemsMockRepository;

    @RequestMapping("/item/all")
    public List<Item> getAllTopics() {
        return itemsMockRepository.findAll();
    }
    
    @RequestMapping("/item/{id}")
    public Item getTopic(@PathVariable("id") Integer id) {
        return itemsMockRepository.find(id);
    }
}