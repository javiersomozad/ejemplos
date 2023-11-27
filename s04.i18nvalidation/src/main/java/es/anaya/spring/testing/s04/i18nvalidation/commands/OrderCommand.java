package es.anaya.spring.testing.s04.i18nvalidation.commands;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrderCommand {
    
	private Long id;
    
    @NotBlank
    @Size(min = 3, max = 255)
    private String description;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date date;
    
    @Min(1)
    @Max(1000)
    private Double total;
}