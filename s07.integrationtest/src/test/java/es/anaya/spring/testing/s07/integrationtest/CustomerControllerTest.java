package es.anaya.spring.testing.s07.integrationtest;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mvc;
	
	@Before
	public void setup() throws Exception {
	    this.mvc = MockMvcBuilders
	    		.webAppContextSetup(this.webApplicationContext).build();
	}
	
	@Test
	public void shouldLoadContextAndController () {
	    ServletContext servletContext = webApplicationContext.getServletContext();
	     
	    Assert.assertNotNull(servletContext);
	    Assert.assertNotNull(webApplicationContext.getBean("customerController"));
	}
	
	@Test
	public void shouldReturnCorrectView () throws Exception {
	    mvc.perform(get("/customer")).andDo(print())
	       .andExpect(view().name("list"));
	    
	    mvc.perform(get("/customer/new")).andDo(print())
	       .andExpect(view().name("new"));
	    
	    mvc.perform(post("/customer/new")).andDo(print())
	       .andExpect(view().name("redirect:/customer"));
	}
	
	@Test
	public void shouldReturnCorrectContent () throws Exception {
	   mvc.perform(get("/customer"))
	      .andDo(print()).andExpect(status().isOk())
	      .andExpect(content().string(containsString("Customers")))
	      .andExpect(content().contentType("text/html;charset=UTF-8"));
	}
}

