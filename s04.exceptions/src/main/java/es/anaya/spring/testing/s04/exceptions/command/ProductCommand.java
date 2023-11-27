package es.anaya.spring.testing.s04.exceptions.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class ProductCommand {
    private Long id;
    private String name;
    private Float price;
}