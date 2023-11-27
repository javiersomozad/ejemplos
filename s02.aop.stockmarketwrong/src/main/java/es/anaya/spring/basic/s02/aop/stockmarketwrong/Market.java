package es.anaya.spring.basic.s02.aop.stockmarketwrong;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		System.out.println("Market> " + trader.getName() 
								+ " trying to buy: " + stockName);
		if (trader.getPermission()) {
			for (Stock s : stocks) {
				if (s.getName().equals(stockName)) {
					stocks.remove(s);
					System.out.println("Market>  DONE ");
					return s;
				}
			}
		}
		System.out.println("Market>  Permission denied for " 
										+ trader.getName());
		return null;
	}

	public Stock sellStock(Stock stock, Trader trader) {
		System.out.println("Market> " + trader.getName() 
							+ " trying to sell: " + stock.getName());
		if (trader.getPermission()) {
			stocks.add(stock);
			System.out.println("Market>  DONE ");
			return stock;
		}
		System.out.println("Market>  Permission denied for " 
				+ trader.getName());
		return null;
	}

}
