package es.anaya.spring.testing.s07.integrationtest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerRestControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void restListShouldReturnJohn() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/customer/api/list",
                String.class)).contains("John Doe");
    }
    
    @Test
    public void createClient() {

        ResponseEntity<Customer> responseEntity =
        		restTemplate.postForEntity("/customer/api/new", new Customer("Foo"), Customer.class);
        
        System.out.println("Entity: " + responseEntity + ", " + responseEntity.getBody());
        Customer customer = responseEntity.getBody();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Foo", customer.getName());

    }
}