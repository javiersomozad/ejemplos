package es.anaya.spring.reactive.s06.streamgenerator.domain;


import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Artist {
    private Long id;
	private String name;
	private String country;
}
