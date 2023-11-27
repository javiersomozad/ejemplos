package es.anaya.spring.badcode.s00.badcoupled;

import java.util.ArrayList;

public class CsvFileDataSource {
	private String filename;
	private String separator;

	public CsvFileDataSource(String filename, String separator) {
		this.filename = filename;
		this.separator = separator;
	}

	public ArrayList<String> loadData() {
		ArrayList<String> lines = new ArrayList<String>();

		lines.add("Customer1, customer1@sample.com, 234 street");
		lines.add("Customer2, customer2@sample.com, 523 street");
		lines.add("Customer3, customer3@sample.com, 231 street");

		return lines;
	}

}
