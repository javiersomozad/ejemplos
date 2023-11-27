package es.anaya.spring.data.s03.onetooneself;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String text;
	private Date date;
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="post_id")
	private Post parent;

	public Post () {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Post getParent() {
		return parent;
	}

	public void setParent(Post parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", text=" + text + ", date=" + date + ", parentid=" +
				((null != parent)? parent.id:"") + " ]";
	}

}
