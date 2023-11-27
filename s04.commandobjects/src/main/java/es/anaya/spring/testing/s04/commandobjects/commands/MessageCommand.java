package es.anaya.spring.testing.s04.commandobjects.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MessageCommand {
    private Long id;
    private String title;
    private String content;
}