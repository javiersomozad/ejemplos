package es.anaya.spring.reactive.s06.reactiverest.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Document
@AllArgsConstructor
public class Artist {
	@Id
    private ObjectId _id;
	private String name;
	private String country;
}
