package es.anaya.spring.testing.s07.controllertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloWebTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/index.html")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Testing sample")));
    }
    
    @Test
    public void helloShouldReturnHelloMessage() throws Exception {
        this.mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("hello")));
    }
    
    @Test
    public void sayShouldReturnHelloMessage() throws Exception {
        this.mockMvc.perform(get("/say")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("This is a message")));
    }
}