package es.anaya.spring.reactive.s06.functionaljava;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class NumberStreamsTest {
	
	private List<Integer> numbers;
	private NumberStreams numberStreams = new NumberStreams();

	@Before
	public void setUp() throws Exception {
		numbers = Arrays.asList(4,7,-4,0,-2,5,-7,0,5,1,-8 ,0,6);
	}

	@Test
	public void testPrint() {
		numberStreams.print(numbers);
	}

	@Test
	public void testParallelPrint() {
		numberStreams.parallelPrint(numbers);
	}

	@Test
	public void testIncrement() {
		numberStreams.increment(numbers);
	}

	@Test
	public void testPositives() {
		numberStreams.positives(numbers);
	}

	@Test
	public void testCountZeroes() {
		numberStreams.countZeroes(numbers);
	}

	@Test
	public void testFirstNegatives() {
		numberStreams.firstNegatives(numbers);
	}

	@Test
	public void testNumbersAsString() {
		numberStreams.numbersAsString(numbers);
	}

	@Test
	public void testSum() {
		numberStreams.sum(numbers);
	}

	@Test
	public void testMax() {
		numberStreams.max(numbers);
	}

	@Test
	public void testCollectSum() {
		numberStreams.collectSum(numbers);
	}

	@Test
	public void testListStats() {
		numberStreams.listStats(numbers);
	}

	@Test
	public void testFlatten() {
		numberStreams.flatten(numbers, numbers, numbers);
	}

	@Test
	public void testGrouped() {
		numberStreams.grouped(numbers);
	}

}
