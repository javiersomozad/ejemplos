package es.anaya.spring.basic.s02.aop.stockmarket;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class OperationMonitor {
	
	@Pointcut("execution(public * *(..))")
	private void anyMethod() {
		System.out.println("Aspect> A trader method was called");
	}

}
