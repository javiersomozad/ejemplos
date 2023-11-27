package es.anaya.spring.reactive.s06.reactiverest.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArtistEvent {
    private String eventId;
    private Date date;
}
