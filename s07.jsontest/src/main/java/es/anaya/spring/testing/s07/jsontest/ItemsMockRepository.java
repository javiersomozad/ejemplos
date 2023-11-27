package es.anaya.spring.testing.s07.jsontest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ItemsMockRepository {

	private List<Item> items;
	
	public ItemsMockRepository () {
		init();
	}
	
	private void init() {
		items = new ArrayList<Item>();
    	
    	items.add(new Item(1L, "Milk", 0.75f));
    	items.add(new Item(2L, "Bread", 0.85f));    	
    	items.add(new Item(3L, "Soap", 2.45f));
	}
	
	public List<Item> findAll () {
		return items;
	}
	
	public Item find(int id) {
		return items.get(id-1);
	}
}
