
package es.anaya.spring.web.s04.webflow;

import org.springframework.stereotype.Component;

@Component
public class ServiceDoSomething {
	
	public ServiceDoSomething() {}

	public void logUser (User user) {
		System.out.println("User is created...");
		System.out.println(user.toString());
	}

}
