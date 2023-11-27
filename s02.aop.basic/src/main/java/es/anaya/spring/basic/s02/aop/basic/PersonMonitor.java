package es.anaya.spring.basic.s02.aop.basic;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PersonMonitor {
	
	// Not necessary if declared in beans.xml file: @After("execution(public * *(..))")
	private void anyMethod() {
		System.out.println("Aspect> A method was called");
	}

}
