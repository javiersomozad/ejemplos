package es.anaya.spring.web.s04.restapiswagger.dto;

import java.util.Date;

public class VideoDTO {
	private Long id;
	private String name;
	private Date createdAt;
	private AuthorDTO authorDTO;

	public VideoDTO() {
	}

	public VideoDTO(Long id, String name, AuthorDTO authorDTO) {
		this.id = id;
		this.name = name;
		this.authorDTO = authorDTO;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public AuthorDTO getAuthorDTO() {
		return authorDTO;
	}

	public void setAuthorDTO(AuthorDTO authorDTO) {
		this.authorDTO = authorDTO;
	}

	@Override
	public String toString() {
		return "VideoDTO [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", authorDTO=" + authorDTO + "]";
	}

}
