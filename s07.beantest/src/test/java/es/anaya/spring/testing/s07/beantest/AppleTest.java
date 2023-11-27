package es.anaya.spring.testing.s07.beantest;

import static org.junit.Assert.*;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class AppleTest {

	@Autowired
	private Apple apple;
	
	@Autowired
	@Value("#{apple}")
	private Apple simpleApple;
	
	@Autowired
	@Qualifier("pinkLadyApple")
	private Apple pinkLadyApple;
	
	@Autowired
	@Resource(name="fujiApple")
	private Apple fujiApple;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void appleShouldAutowire () {
		assertNotNull(apple);
	}

	@Test
	public void appleShouldAutowireByValue() {
		assertNotNull(simpleApple);
	}
	
	@Test
	public void appleShouldAutowireByQualifier () {
		assertNotNull(pinkLadyApple);
	}
	
	@Test
	public void appleShouldAutowireByResourceName () {
		assertNotNull(fujiApple);
	}
}