package es.anaya.spring.services.s05.restclient;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

  private static final String REST_API_GET_ALL = "http://localhost:8080/channel";
  private static final String REST_API_GET_BY_ID = "http://localhost:8080/channel/{id}";
  private static final String REST_API_CREATE = "http://localhost:8080/channel";
  private static final String REST_API_PUT = "http://localhost:8080/channel/{id}";
  private static final String REST_API_DELETE = "http://localhost:8080/channel/{id}";
  
  private RestTemplate restTemplate;
  
  
  public RestClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public Channel[] readAll() {
    return restTemplate.getForObject(REST_API_GET_ALL,Channel[].class);
  }
  
  public Channel[] readAllWithStatus(long id) throws Exception {
    RestTemplate rest = new RestTemplate();
    ResponseEntity<Channel[]> response = 
    		restTemplate.getForEntity(REST_API_GET_ALL, Channel[].class, id);
    
    if(response.getStatusCode() == HttpStatus.FOUND) {
      return response.getBody();
    } else {
      throw new Exception(response.getStatusCode().getReasonPhrase());
    }
  }

  public Channel readOne(String id) {
    Map<String, String> urlVariables = new HashMap<String, String>();
    urlVariables.put("id", id);

    return restTemplate.getForObject(REST_API_GET_BY_ID,Channel.class, id);
  }
  
  public Channel create(Channel channel) throws Exception {
    return restTemplate.postForObject(REST_API_CREATE, channel, Channel.class);
  }
  
  public void update(Channel channel) throws Exception {
    restTemplate.put(REST_API_PUT,channel, channel.getId());
  }
  
  public void delete(String id) throws Exception {
    restTemplate.delete(REST_API_DELETE, id);
  }
}
