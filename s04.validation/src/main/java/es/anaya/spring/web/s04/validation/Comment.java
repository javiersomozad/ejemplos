package es.anaya.spring.web.s04.validation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Comment {
	@NotNull
	@Size(min=2, max=30)
	private String user;
	
	@NotNull
	@Size(min=2, max=255)
	private String text;
	   
    @NotNull
    @Min(0)
    @Max(10)
	private Integer mark;
	
	public Comment () {}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Comment [user=" + user + ", text=" + text + ", mark=" + mark + "]";
	}
	
	
}
