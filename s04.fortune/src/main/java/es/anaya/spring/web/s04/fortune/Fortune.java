package es.anaya.spring.web.s04.fortune;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fortune {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id = 0L;
    private String quote;
    private String author;
    private String type;
    private String lang;

	
	public Fortune () {}


	public Fortune(String quote, String author) {
		this.quote = quote;
		this.author = author;
		type = "default";
		lang = "en";
	}


	public Fortune(String quote, String author, String type, String lang) {
		this.quote = quote;
		this.author = author;
		this.type = type;
		this.lang = lang;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getQuote() {
		return quote;
	}


	public void setQuote(String quote) {
		this.quote = quote;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getLang() {
		return lang;
	}


	public void setLang(String lang) {
		this.lang = lang;
	}


	@Override
	public String toString() {
		return "Fortune [id=" + id + ", quote=" + quote + ", author=" + author + ", type=" + type + ", lang=" + lang
				+ "]";
	} 
	
}
