package es.anaya.spring.reactive.s06.functionaljava;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberLoopsTest {

	private List<Integer> numbers;
	
	@Autowired
	private NumberLoops numberLoops;
	
	@Before
	public void setUp() throws Exception {
		numbers = Arrays.asList(4,5,7,8,2,1,7);
	}

	@Test
	public void testCountOddsClassic() {
		assertEquals(numberLoops.countOdds(numbers), 3);
	}

	@Test
	public void testCountOdds() {
		assertEquals(numberLoops.countOdds(numbers), 3);
	}

	@Test
	public void testCountOddsConsumer() {
		assertEquals(numberLoops.countOdds(numbers), 3);
	}

	@Test
	public void testCountOddsStream() {
		assertEquals(numberLoops.countOdds(numbers), 3);
	}

}
