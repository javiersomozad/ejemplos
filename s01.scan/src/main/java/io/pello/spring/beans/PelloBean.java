package io.pello.spring.beans;

import org.springframework.stereotype.Component;

@Component
public class PelloBean {
	public String doStuff () {
		return "This is Pello's Bean";
	}
}
