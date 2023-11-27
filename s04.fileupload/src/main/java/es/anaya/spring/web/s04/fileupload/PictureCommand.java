package es.anaya.spring.web.s04.fileupload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by jt on 6/21/17.
 */
@Setter
@Getter
@NoArgsConstructor
public class PictureCommand {
    private Long id;
    private String name;
    private Byte[] content;
}