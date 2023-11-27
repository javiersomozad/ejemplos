package es.anaya.spring.basic.s01.xmlandconfig;

public class Numbers {
	private Integer[] numbers = {0,1,2,3,4,5,6,7,8,9};

	public Numbers () {
	}
	
	public Integer[] getNumbers() {
		return numbers;
	}

	public void setNumbers(Integer[] numbers) {
		this.numbers = numbers;
	}

	@Override
	public String toString() {
		String all = "";
		for (Integer number: numbers)
			all = all + number + ", ";
		
		return all;
	}
	
	
}
