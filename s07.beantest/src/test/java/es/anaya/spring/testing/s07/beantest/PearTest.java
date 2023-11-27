package es.anaya.spring.testing.s07.beantest;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:beans.xml"})
public class PearTest {

	@Autowired
	private Pear primaryPear;
	
	@Autowired
	@Resource(name="pear1")
	private Pear pear1;
	
	@Test
	public void primaryAutowiredPearShouldExist() {
		assertNotNull(primaryPear);
	}
	
	@Test
	public void pearAutowiredShouldExist() {
		assertNotNull(pear1);
	}
}