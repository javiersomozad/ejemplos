package es.anaya.spring.reactive.s06.reactiverest;

import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import es.anaya.spring.reactive.s06.reactiverest.domain.Artist;
import reactor.core.publisher.Flux;

@Component
@ConfigurationProperties("client")
public class ConsoleClient {
	private String url;
	private String path;
	
	public Flux<Artist> getArtistStream () {
		return WebClient.builder()
                .baseUrl(url)
                .build()
                .get()
                .uri(path)
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToFlux(Artist.class);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
