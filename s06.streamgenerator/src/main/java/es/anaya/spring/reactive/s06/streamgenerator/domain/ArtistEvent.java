package es.anaya.spring.reactive.s06.streamgenerator.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArtistEvent {
    private String name;
    private Date date;
    private String location;
    private Artist artist;
}
