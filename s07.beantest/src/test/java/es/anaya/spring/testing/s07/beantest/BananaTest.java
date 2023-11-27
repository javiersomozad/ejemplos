package es.anaya.spring.testing.s07.beantest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BananaTest {
	@Autowired
	private Banana banana;
	
	@Test
	public void bananaAutowiredShouldExist() {
		assertNotNull(banana);
	}	
}