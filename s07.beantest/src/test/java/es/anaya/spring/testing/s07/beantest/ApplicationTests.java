package es.anaya.spring.testing.s07.beantest;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private Apple apple1;

	private Apple apple2;
	
	
	@Test
	public void appleAutowiredShouldExist() {
		assertNotNull(apple1);
	}
	
	//Test
	/*public void appleThroughConstructorShouldExist() {
		assertNotNull(apple2);
	}*/
}
