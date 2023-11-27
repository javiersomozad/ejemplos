package es.anaya.spring.basic.s02.aop.custompointcuts;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class GeneratorMonitor {
	
	// This pointcut will look for @MonitorThis
	@Pointcut("@annotation(MonitorThis)")
	public void myPointcutDefinition () { }

    @Pointcut("execution(* es.anaya.spring.basic.s02.aop.custompointcuts.PasswordGenerator.generate (..))")
    public void generateWasCalled() {};
    
	// A catch all pointcut
	@Pointcut("execution(public * *(..))")
	public void anyMethod () {}
	
	@AfterReturning(pointcut="execution(public * PasswordGenerator.generate(..))", returning="password")
	public void checkPassword(JoinPoint joinPoint, Object password) {
		System.out.println("Aspect> Generator was called: " + password);
		if (password.toString().length() > 7) 
			System.out.println("\tAspect> Length is correct.");
	}
	
	@After("generateWasCalled() || myPointcutDefinition()") 
	public void afterSomeMethods (JoinPoint joinPoint) {
		System.out.println("Aspect> Executed after: " + joinPoint.getSignature().getName());
	}
	
	@After("myPointcutDefinition()") 
	public void afterSomeMethods2 (JoinPoint joinPoint) {
		System.out.println("Aspect> fired through annotation: " + joinPoint.getSignature().getName());
	}
}
