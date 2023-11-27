package es.anaya.spring.web.s04.restcrud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
	
	@Autowired
	private WeatherRepository weatherRepository;

  @RequestMapping(value="/weather", method=RequestMethod.GET)
  public List<Weather> getAllWeathers() {
  	
    return (List<Weather>) weatherRepository.findAll();
  }
  
  @RequestMapping(value="/weather/{id}", method=RequestMethod.GET)
  public Weather getWeather(@PathVariable("id") Long id) {
    return weatherRepository.findById(id).get();
  }
  
  @PostMapping("/weather")
  @ResponseBody // { "id": null, "location":"Mordor", "temperature": 777.7 }
  public Weather addWeather(@RequestBody  Weather weather) {
  	System.out.println("This is weather: " + weather);
  	return weatherRepository.save(weather);
  }
  
  @RequestMapping(value = "/weather/{id}", method = RequestMethod.PUT)
  public Weather update(@PathVariable( "id" ) Long id, @RequestBody Weather weather) {
  	Weather oldWeather = weatherRepository.findById(id).get();
  	oldWeather.setLocation(weather.getLocation());
  	oldWeather.setTemperature(weather.getTemperature());
  	
  	weatherRepository.save(oldWeather);
  	return weather;
  }
  
  @RequestMapping(value = "/weather/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable("id") Long id) {
  	weatherRepository.deleteById(id);
  }
  
}