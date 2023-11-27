package es.anaya.spring.basic.s02.aop.pointcuts;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class OrderMonitor {

  @Before("execution(public * *(..))")
  public void beforeAnyMethod() {
    System.out.println("Aspect> Before: restaurant method was called");
  }
  
  @After("execution(public * *(..))")
  public void afterAnyMethod() {
    System.out.println("Aspect> After: A restaurant method was called");
  }
  
  @Before("execution(public * es.anaya.spring.basic.s02.aop.pointcuts.Restaurant.addOrder(..))")
  public void beforeAMethod(JoinPoint joinPoint) {
    System.out.println("Aspect> before addOrder");
    System.out.println("\tJoinPoint: " + joinPoint.getSignature().getName());
  }
  
  @AfterReturning(pointcut = "execution(* es.anaya.spring.basic.s02.aop.pointcuts.Restaurant.addOrder(..))", returning = "orderNumber")
  public void afterAMethod(JoinPoint joinPoint, Object orderNumber) {
    System.out.println("Aspect> after addOrder");
    System.out.println("\tJoinPoint: " + joinPoint.getSignature().getName());
    System.out.println("\t order Nº " + orderNumber);
  }
  
  @AfterThrowing(pointcut = "execution(* es.anaya.spring.basic.s02.aop.pointcuts.Restaurant.addOrder(..))", throwing = "error")
  public void afterThrowing(JoinPoint joinPoint, Throwable error) {
    System.out.println("Aspect> after addOrder");
    System.out.println("\tJoinPoint: " + joinPoint.getSignature().getName());
    System.out.println("\t order Nº " + error.getMessage());
  }
  
  @Around("execution(* es.anaya.spring.basic.s02.aop.pointcuts.Restaurant.addOrder(..))")
  public void aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

    System.out.println("Aspect> around method");
    System.out.println("\tJoinPoint: " + joinPoint.getSignature().getName());
    System.out.println("\tArguments: " + joinPoint.getArgs());

    System.out.println("\tBefore...");
    
    // go on...
    joinPoint.proceed();
    System.out.println("\tAfter...");
  }

}
