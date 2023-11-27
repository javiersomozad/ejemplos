package es.anaya.spring.basic.s01.ymlproperties;

import java.util.Date;

public class Logger {
	
	private String prefix;
	private Boolean showDate;
	
	public Logger () {
		
	}

	public String log (String message) {
		return prefix + giveDate() + message;
	}

	public String giveDate () {
		return showDate?new Date().toString():"";
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public Boolean getShowDate() {
		return showDate;
	}

	public void setShowDate(Boolean showDate) {
		this.showDate = showDate;
	}
	
	
}
