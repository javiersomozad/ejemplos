package es.anaya.spring.basic.s02.aop.stockmarket;

import java.util.ArrayList;
import java.util.List;

public class Market {
	private String name;
	private List<Stock> stocks = new ArrayList<Stock>();

	public Market(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	@Override
	public String toString() {
		return "Market [name=" + name + ", stocks=" + stocks + "]";
	}

	public Stock buyStock(String stockName, Trader trader) {
		for (Stock s : stocks) {
			if (s.getName().equals(stockName)) {
				stocks.remove(s);
				return s;
			}
		}
		return null;
	}

	public Stock sellStock(Stock stock, Trader trader) {
		stocks.add(stock);
		return stock;
	}

}
