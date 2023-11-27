package es.anaya.spring.testing.s07.jsontest;


import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.json.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.json.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@JsonTest
public class ItemJsonTest {

	@Autowired
	private JacksonTester<Item> json;

	@Test
	public void testSerialize() throws Exception {
		Item item = new Item(1L,"Milk", 0.75f);
		
		// Assert against a `.json` file in the same package as the test
		assertThat(this.json.write(item)).isEqualToJson("expected.json");
		
		// Or use JSON path based assertions
		//assertThat(this.json.write(details))
		//		.hasJsonPathStringValue("@.make");
		//assertThat(this.json.write(details))
		//		.extractingJsonPathStringValue("@.make").isEqualTo("Honda");
	}


	@Test
	public void testFieldsValues() throws Exception {
		Item item = new Item(1L,"Milk", 0.75f);

		assertThat(this.json.write(item))
			.hasJsonPathStringValue("@.name");
		assertThat(this.json.write(item))
			.extractingJsonPathStringValue("@.name").isEqualTo("Milk");
	}
	
	@Test
	public void testDeserialize() throws Exception {
		String content = "{\"id\":1,\"name\":\"Milk\",\"price\":0.75}";
		assertThat(this.json.parse(content))
			.isEqualToComparingFieldByField(new Item(1L,"Milk", 0.75f));
		assertThat(this.json.parseObject(content).getName())
			.isEqualTo("Milk");
	}

}
