package es.anaya.spring.basic.s01.lifecycle.replicant;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyCustomBeanProcessor 
				implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) 
    		throws BeansException {
   	 System.out.println("MyCustomProcessor> " + beanName 
   			 				+ "was instantiated. Type: " + bean.getClass()); 
       return bean;
   }
    
    public Object postProcessAfterInitialization(Object bean, String beanName) 
    		throws BeansException {
        System.out.println("MyCustomProcessor> "+ beanName 
        						+ "was destroyed. Type: " + bean.getClass());
        return bean;
    }

}